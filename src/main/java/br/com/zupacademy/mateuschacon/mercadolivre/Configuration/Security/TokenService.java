package br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${mercadoLivre.jwt.expiration}")
    private String expiration;

    
    @Value("${mercadoLivre.jwt.secret}")
    private String secret;


    public String generateToken(Authentication authentication) {
        User logged = (User) authentication.getPrincipal();
        Date nowTime = new Date();
        Date expirationTime = new Date( nowTime.getTime() + Long.parseLong(this.expiration));

        return Jwts.builder()
                .setIssuer("Api Mercado Livre")
                .setSubject(logged.getId().toString())
                .setIssuedAt(nowTime)
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS256,this.secret)
                .compact();
    }


    public boolean isTokenIsValid(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }


    }


    public String getIdUser(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    
}


