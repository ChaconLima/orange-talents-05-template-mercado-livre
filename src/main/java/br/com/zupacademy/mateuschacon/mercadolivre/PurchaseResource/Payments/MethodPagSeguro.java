package br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Payments;

public class MethodPagSeguro implements GatewayInterface{

    @Override
    public String payment(String id) {
        return "pagseguro.com?returnId="+id+"&redirectUrl=";
    }
}
