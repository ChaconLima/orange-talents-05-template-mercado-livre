package br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Category {
    
    /**
     * using the UUID, because I am studying other ways of generating ID
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    @NotBlank
    private String name;

    @ManyToOne
    private Category CategoryMother;

    @Deprecated
    public Category(){}

    public Category(@NotBlank String name, Category categoryMother) {
        this.name = name;
        CategoryMother = categoryMother;
    }
}
