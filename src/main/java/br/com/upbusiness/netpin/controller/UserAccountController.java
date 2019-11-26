package br.com.upbusiness.netpin.controller;

import br.com.upbusiness.netpin.configuration.Message;
import br.com.upbusiness.netpin.dto.BusinessAccountDto;
import br.com.upbusiness.netpin.dto.UserAccountDto;

import br.com.upbusiness.netpin.service.UserAccountService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@RestController
@Validated
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
    ResponseEntity<UserAccountDto> get(@Email @PathVariable String email, @PathVariable String password) throws RestClientResponseException {

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

    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity handleResourceNotFoundException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        List<Message> messages = new ArrayList<>();

        for (ConstraintViolation<?> violation : violations) {
            messages.add(Message.builder().message(violation.getMessage()).build());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messages);
    }
}
