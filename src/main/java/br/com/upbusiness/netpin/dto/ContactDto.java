package br.com.upbusiness.netpin.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    private String id;
    private String contact;
    private String type;
}
