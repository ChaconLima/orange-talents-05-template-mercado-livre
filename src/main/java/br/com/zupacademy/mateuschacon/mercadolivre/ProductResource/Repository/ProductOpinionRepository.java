package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Repository;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductOpinion;

public interface ProductOpinionRepository extends CrudRepository<ProductOpinion, String>{
    
}
