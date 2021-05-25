package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
    
}
