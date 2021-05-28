package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductQuestion;

@Repository
public interface ProductQuestionRepository extends CrudRepository<ProductQuestion, String>{
    
}
