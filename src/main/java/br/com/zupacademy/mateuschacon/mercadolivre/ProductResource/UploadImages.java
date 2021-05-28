package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class UploadImages {

    private List<String> urls = new ArrayList<>();

    public UploadImages(@NotNull @Size(min = 1) List<MultipartFile> imgensList) {
        imgensList.forEach( image->{
            this.urls.add( this.cloud(image));
        });

    }
    
    private String cloud( MultipartFile image){
        return "http://www.xxx.com.br/"+image.getOriginalFilename();
    }

    public List<String> upload(){
        return this.urls;
    } 


}
