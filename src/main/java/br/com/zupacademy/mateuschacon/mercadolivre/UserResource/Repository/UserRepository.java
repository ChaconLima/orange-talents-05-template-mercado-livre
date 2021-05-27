package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

    Optional<User> findByLogin(String login);
    
}
