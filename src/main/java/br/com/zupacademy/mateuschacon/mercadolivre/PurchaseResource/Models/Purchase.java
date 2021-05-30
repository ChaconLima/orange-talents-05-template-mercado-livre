package br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.GenericGenerator;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Product;
import br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Payments.PaymentStatusEnum;
import br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Payments.PaymentGatewayEnum;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

@Entity
public class Purchase {
    
     /**
    *  Attributes
    *==============================================================================*/
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    @NotNull @Positive
    private Long quantityPurchase;

    @Enumerated(EnumType.STRING)
    private PaymentGatewayEnum typePayment;

    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatusEnum = PaymentStatusEnum.INICIADA;

    @NotNull
    private BigDecimal price;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    
    /**
    *  Constructor
    *==============================================================================*/
    @Deprecated
    public Purchase(){}

    public Purchase(@NotNull @Positive Long quantityPurchase,
        @NotBlank String typePayment, @NotNull Product product,@NotNull BigDecimal price ,@NotNull User user) {
        this.quantityPurchase = quantityPurchase;
        this.typePayment = PaymentGatewayEnum.valueOf(typePayment);
        this.product = product;
        this.user = user;
        this.price = price;
    }
    /**
    *  Gets
    *==============================================================================*/
    public PaymentGatewayEnum getTypePayment() {
        return this.typePayment;
    }
    public String getId() {
        return this.id;
    }
    public Long getQuantityPurchase() {
        return quantityPurchase;
    }
}
