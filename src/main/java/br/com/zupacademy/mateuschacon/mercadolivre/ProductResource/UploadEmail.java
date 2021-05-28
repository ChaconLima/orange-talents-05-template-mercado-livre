package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource;


public class UploadEmail {
    
    private String host="exemplo.smtp.mercadolivre.com";

    private String port="exemplo.587";

    private String ssl="exemplo.yes";

    private String user ="exemplo.no-replay@mercadolivre.com";

    private String password="  exemplo.myPassword";

    private String recipientEmail;
 
    private String question;
 
    private String title;

    private String nameProduct;


    public UploadEmail(String recipientEmail, String nameProduct, String question, String title){

        this.recipientEmail = recipientEmail;
        this.question = question;
        this.title = title;
        this.nameProduct = nameProduct;
    }

    private String emailBody(){
        return this.question;
    }

    public boolean send(){

        try {

            String text = "[hots:"+this.host+"]\n[port:"+this.port+"]\n[ssl:"+this.ssl+"]\n[user:"+this.user+"]\n[password:"+this.password+"]\n[recipientEmail:"+this.recipientEmail+"]\n[title:"+this.title+"]\n[product:"+this.nameProduct+"]\n[body:"+this.emailBody()+"]\n";
            System.out.println(text);

            return true;
        } catch (Exception e) {

            return false;
        }
       
      
    }


}
