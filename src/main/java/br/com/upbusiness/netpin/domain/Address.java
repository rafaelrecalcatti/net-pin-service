package br.com.upbusiness.netpin.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "address")
public class  Address {

    @Id
    private String id;

    private String typePublicPlace;

    @Indexed(unique = false)
    private String publicPlace;

    @Indexed(unique = false)
    private Integer number;

    @Indexed(unique = false)
    private String district;

    @Indexed(unique = false)
    private String city;

}
