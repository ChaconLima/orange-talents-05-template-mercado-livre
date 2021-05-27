package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProductFeature {

    /**
    *  Attributes
    *==============================================================================*/
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @ManyToOne
    private Product product;

    /**
    * Constructor 
    *==============================================================================*/
    public ProductFeature(@NotBlank String name, @NotBlank String description, Product product) {
        this.name = name;
        this.description = description;
        this.product = product;
    }

    @Deprecated
    public ProductFeature(){}


    
}
