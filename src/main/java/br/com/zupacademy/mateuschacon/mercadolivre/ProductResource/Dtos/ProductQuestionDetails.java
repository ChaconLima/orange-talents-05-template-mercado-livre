package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductQuestion;

public class ProductQuestionDetails {
    
    private String question;

    public ProductQuestionDetails( ProductQuestion productquestion){
        this.question = productquestion.getTitle();
    }

    public String getTitle() {
        return this.question;
    }
}
