package br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.mercadolivre.CategoryResource.Models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,String>{
    
}
