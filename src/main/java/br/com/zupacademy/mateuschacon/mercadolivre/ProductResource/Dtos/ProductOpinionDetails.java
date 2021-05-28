package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductOpinion;

public class ProductOpinionDetails {
    
    private Integer note;

    private String title;
   
    private String descripion;


    public ProductOpinionDetails( ProductOpinion productOpinion  ){
        this.note = productOpinion.getNote();
        this.title=productOpinion.getTitle();
        this.descripion=productOpinion.getDescripion();
    }
    public String getDescripion() {
        return this.descripion;
    }
    public Integer getNote() {
        return this.note;
    }
    public String getTitle() {
        return this.title;
    }
}
