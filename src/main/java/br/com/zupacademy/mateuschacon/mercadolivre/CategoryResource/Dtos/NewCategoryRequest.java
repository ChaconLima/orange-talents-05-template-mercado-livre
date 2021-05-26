package br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Dtos;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Models.Category;
import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Repository.CategoryRepository;
import br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom.ExisteEntity;
import br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom.UniqueValue;

public class NewCategoryRequest {

    @NotBlank @UniqueValue(domainClass = Category.class , fieldName = "name")
    private String name;


    @ExisteEntity(domainClass = Category.class, fieldName = "id")
    private String idCategoryMother =null;


    public NewCategoryRequest(@NotBlank String name, String idCategoryMother) {
        this.name = name;
        this.idCategoryMother = idCategoryMother;
    }

    public Category toModel( CategoryRepository categoryRepository){

        if(this.idCategoryMother == null){
            return new Category(this.name, null);
        }
        Optional<Category> category = categoryRepository.findById(this.idCategoryMother);
    
        return new Category(this.name, category.get());
       
    }

}
