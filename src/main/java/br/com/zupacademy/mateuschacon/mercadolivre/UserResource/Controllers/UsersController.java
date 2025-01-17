package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Dtos.NewUserRequest;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Repository.UserRepository;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> UserRegistration(@RequestBody @Valid NewUserRequest newUserRequest){
        
        User user = newUserRequest.toModel();
        this.userRepository.save(user);
        
        return ResponseEntity.ok().build();
    }
    
}
