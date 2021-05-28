package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

@Entity
public class ProductQuestion {
    /**
    *  Attributes
    *==============================================================================*/
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    private LocalDateTime registrationTime = LocalDateTime.now();

    @NotBlank
    private String title;

    @ManyToOne
    private User user;


    @ManyToOne
    private Product product;

    /**
    *  Constructor
    *==============================================================================*/
    @Deprecated
    public ProductQuestion(){}

    
    public ProductQuestion(@NotBlank String title, User user, Product product) {
        this.title = title;
        this.user = user;
        this.product = product;
    }

    /**
    *  Gets
    *==============================================================================*/
    public String getTitle() {
        return this.title;
    }
}
