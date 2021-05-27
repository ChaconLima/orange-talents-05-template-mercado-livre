package br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService{


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        
       Optional <User> user = this.userRepository.findByLogin(login);

       if(user.isPresent()){
           return user.get();
       }

        throw new UsernameNotFoundException("not valid");
    }
    
}
