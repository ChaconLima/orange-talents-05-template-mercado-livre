package br.com.zupacademy.mateuschacon.mercadolivre.PurchaseResource.Payments;

public enum PaymentGatewayEnum {
    
    PAYPAL(new MethodPayPal()),
    PAGSEGURO(new MethodPagSeguro());

    private GatewayInterface paymentInterface;

    PaymentGatewayEnum(GatewayInterface paymentsInterface){
        this.paymentInterface=paymentsInterface;
    }
    public GatewayInterface getPaymentInterface(){
        return this.paymentInterface;
    }
}
