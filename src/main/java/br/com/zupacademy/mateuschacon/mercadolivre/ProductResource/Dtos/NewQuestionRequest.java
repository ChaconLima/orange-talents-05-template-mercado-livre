package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Product;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductQuestion;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

public class NewQuestionRequest {
    
    @NotBlank
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public ProductQuestion toModel(@Valid User user, @Valid Product product) {
        return new ProductQuestion( this.title, user, product);
    }
}
