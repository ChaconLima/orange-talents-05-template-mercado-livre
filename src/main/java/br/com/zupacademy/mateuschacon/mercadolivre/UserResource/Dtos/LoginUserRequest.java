package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginUserRequest {

    @NotBlank @Email
    private String login;
    @NotBlank @Length(min = 6)
    private String password;
    
    public LoginUserRequest(@NotBlank @Email String login, @NotBlank @Length(min = 6) String password) {
        this.login = login;
        this.password = password;
    }

    public UsernamePasswordAuthenticationToken converte() {
        return new UsernamePasswordAuthenticationToken(this.login, this.password);
    }
}
