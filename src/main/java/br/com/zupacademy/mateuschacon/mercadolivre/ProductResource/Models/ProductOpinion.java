package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

@Entity
public class ProductOpinion {
    
    /**
    *  Attributes
    *==============================================================================*/
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;
    @Min(1) @Max(5)
    private Integer note;
    @NotBlank
    private String title;
    @NotBlank @Size(max = 500)
    private String descripion;

    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    /**
    *  Constructor
    *==============================================================================*/
    @Deprecated
    public ProductOpinion(){}

    public ProductOpinion(@Min(1) @Max(5) Integer note, @NotBlank String title,
            @NotBlank @Size(max = 500) String descripion, User user, Product product) {
        this.note = note;
        this.title = title;
        this.descripion = descripion;
        this.user = user;
        this.product = product;
    }

}
