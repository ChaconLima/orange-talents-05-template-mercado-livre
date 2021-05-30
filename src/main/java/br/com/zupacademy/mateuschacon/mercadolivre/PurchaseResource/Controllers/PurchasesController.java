package br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.UploadEmail;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Product;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Repository.ProductRepository;
import br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Dtos.NewPurchaseRequest;
import br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Models.Purchase;
import br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Repositorys.PurchaseRepository;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/api/purchases")
public class PurchasesController {
    
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PurchaseRepository purchaseRepository;

    @PostMapping
    public ResponseEntity<?> newPurchase(@RequestBody @Valid NewPurchaseRequest newPurchaseRequest,  UriComponentsBuilder uriBuilder) throws URISyntaxException {
        /**
         * retrieve the user and the product
         */
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        
        Optional<Product> fieldProduct=this.productRepository.findById(newPurchaseRequest.getProductIdentifier());
        Product product = fieldProduct.get();

        /**
        * stock rebate
        */
        if( product.isValidPurchase( newPurchaseRequest.getQuantityPurchase()) ){

            /**entity object creation */
            Purchase purchase =  newPurchaseRequest.toModel(product, user);

             /**sending email */
            String massageEmail = "Usuário '"+user.getUsername()+"' comprou '"+ purchase.getQuantityPurchase()+ "' unidades do produto '"+product.getName()+"'.";
            UploadEmail email =new UploadEmail( 
                                    product.getUser().getUsername(),
                                    product.getName(), 
                                    massageEmail, 
                                    "Venda"
                                    );
            email.send();

            /**
            * updating the product and saving the purchase to the database
            */
            this.purchaseRepository.save(purchase);
            this.productRepository.save(product);

            /**
             * payment method
             */
            String methodPayment = purchase.getTypePayment().getPaymentInterface().payment(purchase.getId());

            URI uri = uriBuilder.path("/api/purchases/{id}").buildAndExpand(purchase.getId()).toUri();
            URI url = new URI(methodPayment+uri);

            return ResponseEntity.created(url).build();
       }

        return ResponseEntity.notFound().build();
    }
    
}
