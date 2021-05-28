package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.Product;

public class ProductDetailsResponse {
 
    private String name;

    private BigDecimal value;

    private String description;

    private List<ProductFeaturesDetails> features = new ArrayList<>();
    
    private List<ProductImageDetails> images = new ArrayList<>();

    private List<ProductOpinionDetails> opnions = new ArrayList<>();

    private List<ProductQuestionDetails> questions= new ArrayList<>();

    private OptionalDouble averageGrade;

    private Long totalGrades;
      
    public ProductDetailsResponse(Product product) {

        this.name = product.getName();
        this.value = product.getValue();
        this.description = product.getDescription();

        List<ProductFeaturesDetails> productFeatures = product.getFeatures().stream().map( productFeature-> new ProductFeaturesDetails(productFeature)).collect(Collectors.toList());
        this.features.addAll(productFeatures);

        List<ProductImageDetails> productImages = product.getImages().stream().map( productImage-> new ProductImageDetails(productImage)).collect(Collectors.toList());
        this.images.addAll(productImages);

        List<ProductOpinionDetails> productOpinions = product.getOpinions().stream().map( productOpinion -> new ProductOpinionDetails(productOpinion)).collect(Collectors.toList());
        this.opnions.addAll(productOpinions);

        List<Integer> notes = product.getOpinions().stream().map(note-> note.getNote()).collect(Collectors.toList());
        this.averageGrade = notes.stream().mapToInt(note->note).average();

        this.totalGrades = Long.valueOf(this.opnions.size());

        List<ProductQuestionDetails> productQuestions = product.getQuestions().stream().map( productQuestion -> new ProductQuestionDetails(productQuestion)).collect(Collectors.toList());
        this.questions.addAll(productQuestions);
    }


    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public BigDecimal getValue() {
        return this.value;
    }
    public List<ProductFeaturesDetails> getFeatures() {
        return this.features;
    }
    public List<ProductImageDetails> getImages() {
        return this.images;
    }
    public List<ProductOpinionDetails> getOpnions() {
        return this.opnions;
    }
    public List<ProductQuestionDetails> getQuestions() {
        return this.questions;
    }
    public OptionalDouble getAverageGrade() {
        return this.averageGrade;
    }
    public Long getTotalGrades() {
        return this.totalGrades;
    }
}
