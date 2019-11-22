package br.com.upbusiness.netpin.service;

import br.com.upbusiness.netpin.domain.Image;
import br.com.upbusiness.netpin.repository.ImageRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String addImage(String title, MultipartFile file){
        String idImage = null;

        try {
            idImage = imageRepository.save(
                    Image.builder().title(title).image(new Binary(BsonBinarySubType.BINARY, file.getBytes())).build()).getId();
        } catch (IOException ex) {

        }

        return idImage;
    }

    @Override
    public Image getImage(String id) {
        return imageRepository.findById(id).orElse(null);
    }

}
