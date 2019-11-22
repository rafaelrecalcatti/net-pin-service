package br.com.upbusiness.netpin.service;


import br.com.upbusiness.netpin.domain.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface ImageService {

    public abstract String addImage(String title, MultipartFile file);

    public abstract Image getImage(String id);

}
