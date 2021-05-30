package br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Payments;

public class MethodPayPal implements GatewayInterface {

    @Override
    public String payment(String id) {
        return "paypal.com?buyerId="+id+"&redirectUrl=";
    }
    
}
