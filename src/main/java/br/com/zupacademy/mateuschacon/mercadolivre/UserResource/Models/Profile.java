package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Profile implements GrantedAuthority {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    private String id;
    private String name;
 
    public Profile(String name) {
        this.name = name;
    }

    @Deprecated
    public Profile(){}

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
    
}
