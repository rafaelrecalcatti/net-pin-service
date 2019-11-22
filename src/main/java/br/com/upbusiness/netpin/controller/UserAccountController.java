package br.com.upbusiness.netpin.controller;

import br.com.upbusiness.netpin.dto.BusinessAccountDto;
import br.com.upbusiness.netpin.dto.UserAccountDto;

import br.com.upbusiness.netpin.service.UserAccountService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @ResponseStatus(code = HttpStatus.FOUND)
    @RequestMapping(value = "/user-account/{id}", method = RequestMethod.GET)
        //@GetMapping("/user-account/{id}")
    ResponseEntity<UserAccountDto> get(@PathVariable String id) {

        ResponseEntity responseEntity = null;
        UserAccountDto userAccountDto = userAccountService.findById(id);

        if (userAccountDto.getId() != null) {
            responseEntity = ResponseEntity.status(HttpStatus.FOUND).body(userAccountDto);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        return responseEntity;
    }

    @ResponseStatus(code = HttpStatus.FOUND)
    @RequestMapping(value = "/user-account/{email}/{password}", method = RequestMethod.GET)
    ResponseEntity<UserAccountDto> get(@PathVariable String email, @PathVariable String password) {

        ResponseEntity responseEntity = null;
        UserAccountDto userAccountDto = userAccountService.findByUserAccount(email, password);

        if (userAccountDto != null) {
            responseEntity = ResponseEntity.status(HttpStatus.FOUND)
                    .body(userAccountDto);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.CREATED)
                    .body(userAccountService.createUserAccount(UserAccountDto.builder().email(email).password(password).build()));
        }
        return responseEntity;
    }

    @PostMapping(value = "/user-account")
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<UserAccountDto> save(@RequestBody UserAccountDto userAccountDto) {

        ResponseEntity responseEntity = null;
        UserAccountDto userAccountDtoResponse = userAccountService.createUserAccount(userAccountDto);

        if (userAccountDtoResponse != null) {
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(userAccountDtoResponse);
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("QR-Code já utilizado");
        }
        return responseEntity;
    }

}
