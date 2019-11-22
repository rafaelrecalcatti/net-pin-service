package br.com.upbusiness.netpin.domain;

import br.com.upbusiness.netpin.dto.AddressDto;
import br.com.upbusiness.netpin.dto.ContactDto;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;

import java.util.ArrayList;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "business-account")
public class BusinessAccount {

    @Id
    private String id;

    @Indexed(unique = true)
    private String qrCode;

    @Indexed(unique = false)
    private String password;

    @Indexed(unique = false)
    private String name;

    private String category;

    private Location location;

    //private String image;

    //private String iconPin;

    private ArrayList<Address> addressList;

    private ArrayList<Contact> contactList;

}
