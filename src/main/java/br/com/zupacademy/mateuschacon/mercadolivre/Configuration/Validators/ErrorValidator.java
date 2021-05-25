package br.com.zupacademy.mateuschacon.mercadolivre.Configuration.Validators;

public class ErrorValidator {
    private String error;
    private String message;


    public ErrorValidator(String error, String message) {
        this.error = error;
        this.message = message;
    }
    public String getError() {
        return error;
    }
    public String getMessage() {
        return message;
    }
}
