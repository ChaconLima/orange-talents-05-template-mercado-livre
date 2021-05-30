package br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom.ExisteEntity;
import br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom.ValidEnum;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Product;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;
import br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Models.Purchase;
import br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Payments.PaymentGatewayEnum;

public class NewPurchaseRequest {
    
    @NotBlank @ExisteEntity(domainClass = Product.class, fieldName = "id")
    private String productIdentifier;

    @NotNull @Positive
    private Long quantityPurchase;

    @NotBlank @ValidEnum( domainClass= PaymentGatewayEnum.class )
    private String typePayment;

    public NewPurchaseRequest(@NotBlank String productIdentifier, @NotNull @Positive Long quantityPurchase,
            @NotBlank String typePayment) {
        this.productIdentifier = productIdentifier;
        this.quantityPurchase = quantityPurchase;
        this.typePayment = typePayment;
    }

    public String getProductIdentifier() {
        return this.productIdentifier;
    }
    public Long getQuantityPurchase() {
        return this.quantityPurchase;
    }

    public Purchase toModel(Product product, User user){

        BigDecimal price =  product.getValue().multiply( new BigDecimal(this.quantityPurchase));

        return new Purchase(this.quantityPurchase, this.typePayment, product, price ,user);
    }


}
