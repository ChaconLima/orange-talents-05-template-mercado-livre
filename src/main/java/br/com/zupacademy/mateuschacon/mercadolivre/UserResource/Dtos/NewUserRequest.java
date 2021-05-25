package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators.Custom.UniqueValue;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;

public class NewUserRequest {
    
    @NotBlank @Email @UniqueValue(domainClass = User.class, fieldName = "login")
    private String login;
    @NotBlank @Length(min = 6)
    private String password;
    
    public NewUserRequest(@NotBlank @Email String login, @NotBlank @Length(min = 6) String password) {
        this.login = login;
        this.password = password;
    }

    public User toModel(){
        ClearPassword clearPassword = new ClearPassword(this.password);
        return new User(this.login, clearPassword.hash() );
    }

}
