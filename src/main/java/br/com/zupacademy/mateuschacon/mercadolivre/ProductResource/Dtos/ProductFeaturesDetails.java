package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;


import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductFeature;

public class ProductFeaturesDetails {

    private String name;

    private String description;

    public ProductFeaturesDetails(ProductFeature productFeature) {
        this.name = productFeature.getName();
        this.description = productFeature.getDescription();
    }

    public String getDescription() {
        return this.description;
    }
    public String getName() {
        return this.name;
    }

}
