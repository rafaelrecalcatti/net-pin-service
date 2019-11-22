package br.com.upbusiness.netpin.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user-account")
public class UserAccount {

    @Id
    private String id;

    private String name;

    private LocalDate birthDate;

    @Indexed(unique = true)
    private String email;

    @Indexed(unique = true)
    private String password;

    private Location location;

    private List<BusinessAccount> businessAccountList;

}
