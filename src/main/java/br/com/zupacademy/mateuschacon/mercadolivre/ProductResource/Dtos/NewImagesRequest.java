package br.com.zupacademy.mateuschacon.mercadolivre.ProductResource.Dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class NewImagesRequest {
    
    @NotNull @Size(min = 1)
    private List<MultipartFile> imgensList = new ArrayList<>();

    public void setImgensList(List<MultipartFile> imgensList) {
        this.imgensList = imgensList;
    }
    public List<MultipartFile> getImgensList() {
        return this.imgensList;
    }

}
