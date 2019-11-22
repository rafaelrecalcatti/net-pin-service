package br.com.upbusiness.netpin.domain;

import lombok.*;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "icons")
public class Image {

    @Id
    private String id;
    private String title;
    private Binary image;
}
