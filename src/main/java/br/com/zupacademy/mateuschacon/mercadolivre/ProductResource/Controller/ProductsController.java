package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Repository.CategoryRepository;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.UploadImages;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos.NewImagesRequest;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos.NewOpinionRequest;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos.NewProductRequest;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Product;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductOpinion;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Repository.ProductOpinionRepository;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Repository.ProductRepository;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/api/products")
public class ProductsController {
    
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductOpinionRepository opinionRepository;

    

    @PostMapping
    public ResponseEntity<?> productRegistration(@RequestBody @Valid NewProductRequest newProductRequest) {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
    
        Product product = newProductRequest.toModel(this.categoryRepository, userRepository, user.getId());
        this.productRepository.save(product);


        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/images")
    public ResponseEntity<?> uploadImages(@PathVariable("id") String id_product, @Valid NewImagesRequest newImagesReqeust){
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        Optional<Product> productIsValid = this.productRepository.findByIdAndUser_id(id_product, user.getId());
        
        if(productIsValid.isPresent()){

            /**
             * entity recovery
             */
            Product product = productIsValid.get();

             /**
             * upload process
             */
            UploadImages uploadImages = new UploadImages(newImagesReqeust.getImgensList());
            List<String>imagesUrlList = uploadImages.upload();

            /**
             * inserting the images into the product
             */
            product.addImages(imagesUrlList);

            /**
            * saving the updated product with the images
            */
            this.productRepository.save(product);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();


        
    }

    
    @PostMapping("/{id}/opinion")
    public ResponseEntity<?> opinionRegistration(@PathVariable("id") String id_product, @RequestBody @Valid NewOpinionRequest newOpinionRequest){
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        Optional<Product> product = this.productRepository.findById(id_product);
 
        if(product.isPresent()){
                
            ProductOpinion  productOpinion = newOpinionRequest.toModel( user, product.get());

            this.opinionRepository.save(productOpinion);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
