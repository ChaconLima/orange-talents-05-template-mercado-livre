package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

import java.util.Set;

import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Models.Category;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos.NewImagesRequest;
import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos.NewProductFeatureRequest;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

@Entity
public class Product {
    
    /**
    *  Attributes
    *==============================================================================*/
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    @NotBlank
    private String name;

    @NotNull @Positive
    private BigDecimal value;

    @NotNull @Positive
    private String quantity;

    @NotBlank @Size(max = 1000)
    private String description;

    @NotNull
    private LocalDateTime registrationTime;

    @ManyToOne
    private Category category;

    @OneToMany( mappedBy = "product", cascade = CascadeType.PERSIST)
    private Set<ProductFeature> features = new HashSet<>();

    @ManyToOne @NotNull
    private User user;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    private Set<Image> images = new HashSet<>();

    /**
     * Constructor 
     *==============================================================================*/
    @Deprecated
    public Product(){}

    public Product(@NotBlank String name, @NotNull @Positive BigDecimal value, @NotNull @Positive String quantity,
            @NotBlank @Size(max = 1000) String description, @NotNull LocalDateTime registrationTime, Category category,
            @Size(min=3) @Valid Collection<NewProductFeatureRequest> features, @NotNull User user) {
        this.name = name;
        this.value = value;
        this.quantity = quantity;
        this.description = description;
        this.registrationTime = registrationTime;
        this.category = category;
        Set <ProductFeature> newFeatures = features.stream().map( feature-> feature.toModel(this)).collect(Collectors.toSet());
        this.features.addAll(newFeatures);
        this.user=user;
    }
     /**
     * Methods 
     *==============================================================================*/
    public void addImages( Collection<String> imagesUrlList){

        Set<Image>newImages = new HashSet<>(); 
        imagesUrlList.forEach( url->{

            Image image = new Image(url, this);
            newImages.add(image);

        });
        this.images.addAll(newImages);
    }
    /**
     * Gets 
     *==============================================================================*/
    public String getId() {
        return this.id;
    }
}



