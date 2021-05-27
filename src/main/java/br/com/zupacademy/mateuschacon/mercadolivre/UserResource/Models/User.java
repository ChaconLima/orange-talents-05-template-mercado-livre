package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
    
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
 
    @Deprecated
    public User(){}

    public User(@NotBlank @Email String login, @NotBlank String password) {
        this.login = login;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Profile> profiles = new ArrayList<>();

    public String getId() {
        return this.id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        return this.profiles;
    }

    @Override
    public String getPassword() {
       
        return this.password;
    }

    @Override
    public String getUsername() {
       
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
       
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return true;
    }
}
