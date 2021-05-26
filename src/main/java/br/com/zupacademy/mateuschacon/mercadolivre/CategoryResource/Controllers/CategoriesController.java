package br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Dtos.NewCategoryRequest;
import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Models.Category;
import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Repository.CategoryRepository;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoriesController {
    
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<?> CategoryRegistration(@RequestBody @Valid NewCategoryRequest newCategoryRequest){

        Category category = newCategoryRequest.toModel(this.categoryRepository);
        this.categoryRepository.save(category);
        
        return ResponseEntity.ok().build();
    }
}
