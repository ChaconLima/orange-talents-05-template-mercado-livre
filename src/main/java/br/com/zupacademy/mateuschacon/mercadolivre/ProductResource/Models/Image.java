package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Image {
    /**
    *  Attributes
    *==============================================================================*/
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    @NotBlank
    private String url;

    @ManyToOne
    private Product product;

    /**
    *  Constructor
    *==============================================================================*/
    @Deprecated
    public Image(){}

    public Image(@NotBlank String url, Product product) {
        this.url = url;
        this.product = product;
    }

    /**
    *  Gets
    *==============================================================================*/
    public String getUrl() {
        return this.url;
    }
}
