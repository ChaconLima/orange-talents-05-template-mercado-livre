package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Models.ProductOpinion;

@Repository
public interface ProductOpinionRepository extends CrudRepository<ProductOpinion, String>{
    
}
