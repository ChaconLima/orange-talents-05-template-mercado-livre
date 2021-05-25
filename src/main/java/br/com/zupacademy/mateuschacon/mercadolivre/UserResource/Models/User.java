package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;

    @NotBlank @Email
    private String login;

    @NotBlank
    private String password;

    private LocalDateTime registrationTime = LocalDateTime.now();
 
    public User(@NotBlank @Email String login, @NotBlank String password) {
        this.login = login;
        this.password = password;
    }
}
