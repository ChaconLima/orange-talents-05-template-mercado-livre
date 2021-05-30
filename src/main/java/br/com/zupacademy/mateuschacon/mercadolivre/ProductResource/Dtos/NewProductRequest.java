package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Models.Category;
import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Repository.CategoryRepository;
import br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom.DuplicateFeatureValue;
import br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom.ExisteEntity;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Product;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Repository.UserRepository;

@DuplicateFeatureValue()
public class NewProductRequest {
    
    /**
    *  Attributes
    *==============================================================================*/
    @NotBlank
    private String name;

    @NotNull @Positive
    private BigDecimal value;

    @NotNull @Positive
    private Long quantity;

    @NotBlank @Size(max = 1000)
    private String description;

    @NotBlank @ExisteEntity(domainClass = Category.class, fieldName = "id")
    private String  identifierCategory;

    private LocalDateTime registrationTime = LocalDateTime.now();

    @Size( min =  3)
    private List<@Valid NewProductFeatureRequest > features = new ArrayList<>();


    /**
     * Constructor 
     *==============================================================================*/
    public NewProductRequest(@NotBlank String name, @NotNull @Positive BigDecimal value,
            @NotNull @Positive Long quantity, @NotBlank @Size(max = 1000) String description,
            @NotBlank String identifierCategory, @NotNull @Size(min = 3) List<@Valid NewProductFeatureRequest> features) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.description = description;
        this.identifierCategory = identifierCategory;
        this.features.addAll(features);
    }


    /**
     * Methods
     *==============================================================================*/
    public Product toModel(CategoryRepository categoryRepository, UserRepository userRepository, String identifierUser){

        Optional<User>user = userRepository.findById(identifierUser);
        Optional<Category>category = categoryRepository.findById(this.identifierCategory);

        return new Product(this.name, 
                            this.value,
                            this.quantity, 
                            this.description, 
                            this.registrationTime, 
                            category.get(), 
                            this.features,
                            user.get());
    }

    public boolean duplicateValue(){
        
        HashSet<String> namesEquals = new HashSet<>();
        for (NewProductFeatureRequest newFeatureRequest : this.features) {
            if(!namesEquals.add(newFeatureRequest.getName())){
                return false;
            }
        }
        return true;
    }

    /**
     * Methods Gets
     *==============================================================================*/
    public List<NewProductFeatureRequest> getFeatures() {
        return this.features;
    }
}
