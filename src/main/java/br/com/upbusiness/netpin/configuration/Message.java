package br.com.upbusiness.netpin.configuration;

import lombok.*;
import lombok.experimental.Wither;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Wither
public class Message {

    private String message;
}
