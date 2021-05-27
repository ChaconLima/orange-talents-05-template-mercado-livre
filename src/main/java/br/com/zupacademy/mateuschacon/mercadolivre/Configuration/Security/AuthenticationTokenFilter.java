package br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Models.User;
import br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Repository.UserRepository;

public class AuthenticationTokenFilter extends OncePerRequestFilter{

    private TokenService tokenService;
    private UserRepository userRepository;

    public AuthenticationTokenFilter(TokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService; this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String token = this.requestToken(request);
        boolean isValid =this.tokenService.isTokenIsValid(token);

        if(isValid){
            this.authUser(token);
        }

        filterChain.doFilter(request, response);
        
    }

    private void authUser(String token) {

        String id = this.tokenService.getIdUser(token);
        Optional<User> user = this.userRepository.findById(id);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.get(),null, user.get().getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String requestToken(HttpServletRequest request) {
        String token=request.getHeader("Authorization");
        if(token==null || token.isEmpty()|| !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }
    
}