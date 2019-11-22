package br.com.upbusiness.netpin.dto;


import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private String id;
    private String latitude;
    private String longitude;
}
