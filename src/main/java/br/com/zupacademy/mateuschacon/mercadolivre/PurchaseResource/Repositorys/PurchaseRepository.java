package br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Models.Purchase;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase,String> {
    
}
