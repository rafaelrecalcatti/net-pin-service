package br.com.upbusiness.netpin.dto;

import lombok.*;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessAccountDto {

    private String id;
    private String qrCode;
    private String password;
    private String name;
    private String category;
    //private BufferedImage image;
    //private BufferedImage pin;
    private LocationDto location;
    private ArrayList<AddressDto> addressList;
    private ArrayList<ContactDto> contactList;

}
