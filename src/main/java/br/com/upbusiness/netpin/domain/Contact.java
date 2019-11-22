package br.com.upbusiness.netpin.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "contact")
public class Contact {

    @Id
    private String id;

    @Indexed(unique = false)
    private String contact;

    private String type;
}
