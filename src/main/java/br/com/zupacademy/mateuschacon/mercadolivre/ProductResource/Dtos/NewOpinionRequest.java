package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Product;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductOpinion;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

public class NewOpinionRequest {
    

    @Min(1) @Max(5)
    private Integer note;
    @NotBlank
    private String title;
    @NotBlank @Size(max = 500)
    private String descripion;

    public NewOpinionRequest(Integer note, String title, String descripion) {
        this.note = note;
        this.title = title;
        this.descripion = descripion;
    }

    public ProductOpinion toModel(User user, Product product) {
        return new ProductOpinion(this.note, this.title, this.descripion, user, product) ;
    }

 
    
}
