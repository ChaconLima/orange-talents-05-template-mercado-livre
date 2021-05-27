package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Security.TokenService;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Dtos.LoginUserRequest;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Dtos.LoginUserResponse;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {
    

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<LoginUserResponse> authentication(@RequestBody @Valid LoginUserRequest loginUserRequest){

        UsernamePasswordAuthenticationToken login = loginUserRequest.converte();

        try {

            Authentication authentication =  this.authenticationManager.authenticate(login);
            String token = this.tokenService.generateToken(authentication);
            
            return ResponseEntity.ok(new LoginUserResponse(token,"Bearer"));

        } catch (Exception e) {

            return ResponseEntity.badRequest().build();
        }

    }
}
