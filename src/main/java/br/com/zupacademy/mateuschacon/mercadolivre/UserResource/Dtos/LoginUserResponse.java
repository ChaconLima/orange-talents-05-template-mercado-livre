package br.com.zupacademy.mateuschacon.mercadolivre.UserResource.Dtos;

public class LoginUserResponse {


    private String token;
    private String type;    

    public LoginUserResponse(String token, String string) {
        this.token=token;
        this.type=string;
    }
    
    public String getToken() {
        return token;
    }
    public String getType() {
        return type;
    }
}
