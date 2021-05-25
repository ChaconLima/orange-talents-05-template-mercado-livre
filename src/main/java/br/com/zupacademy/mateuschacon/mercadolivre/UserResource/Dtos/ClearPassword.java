package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Dtos;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

public class ClearPassword {

    @NotBlank @Length(min = 6)
    private String password;
    
    /**
    * @param password, cannot be blank and the length must be at least = 6
    */
    public ClearPassword(@NotBlank @Length(min = 6) String password) {

        Assert.hasLength(password, "password cannot be null");
        Assert.isTrue(password.length()>=6, "password length must be at least = 6");

        this.password =new BCryptPasswordEncoder().encode(password);
    }

    public String hash(){
        return this.password;
    }

}
