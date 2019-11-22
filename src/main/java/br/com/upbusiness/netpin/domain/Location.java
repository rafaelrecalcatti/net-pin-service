package br.com.upbusiness.netpin.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "location")
public class Location {

    @Id
    private String id;

    private String latitude;

    private String longitude;
}
