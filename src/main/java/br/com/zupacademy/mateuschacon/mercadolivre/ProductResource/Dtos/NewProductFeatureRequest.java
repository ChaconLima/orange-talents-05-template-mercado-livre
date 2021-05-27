package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.jetbrains.annotations.NotNull;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductFeature;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Product;

public class NewProductFeatureRequest {
    /**
    *  Attributes
    *==============================================================================*/
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    /**
    * Constructor 
    *==============================================================================*/

    public NewProductFeatureRequest(@NotBlank String name, String description) {
        this.name = name;
        this.description = description;
    }
    /**
    * Methods Gets
    *==============================================================================*/
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }

    /**
    * Methods
    *==============================================================================*/
    public ProductFeature toModel(@NotNull @Valid Product product){
        return new ProductFeature(this.name, this.description, product);
    }
}
