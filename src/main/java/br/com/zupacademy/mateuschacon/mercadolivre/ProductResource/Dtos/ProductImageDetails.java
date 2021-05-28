package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;


import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Image;

public class ProductImageDetails {

    private String url;

    public ProductImageDetails( Image image){
        this.url= image.getUrl();
    }

    public String getUrl() {
        return this.url;
    }
}
