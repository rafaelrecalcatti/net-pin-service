package br.com.upbusiness.netpin.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String id;
    private String typePublicPlace;
    private String publicPlace;
    private Integer number;
    private String district;
    private String city;
    private String address;


    public String getAddress() {
        return new StringBuilder().
                append(typePublicPlace).
                append(" ").
                append(publicPlace).
                append(" n°").
                append(number).
                append(" ,").
                append(district).
                append(" - ").
                append(city).
                toString();
    }

}
