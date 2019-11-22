package br.com.upbusiness.netpin.dto;

import lombok.*;
import org.bson.types.Binary;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {

    private String id;
    private String title;
    private Binary image;
}
