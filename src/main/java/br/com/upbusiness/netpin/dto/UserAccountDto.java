package br.com.upbusiness.netpin.dto;

import br.com.upbusiness.netpin.domain.Location;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDto {

    private String id;

    @NotBlank(message = "Nome é obrigatorio")
    private String name;

    private LocalDate birthDate;

    @NotBlank(message = "Email é obrigatorio")
    private String email;

    private String password;

    private Location location;

    private List<BusinessAccountDto> businessAccountList;

}

