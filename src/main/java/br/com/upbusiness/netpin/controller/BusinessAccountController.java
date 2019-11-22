package br.com.upbusiness.netpin.controller;

import br.com.upbusiness.netpin.service.BusinessAccountService;
import br.com.upbusiness.netpin.dto.BusinessAccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class BusinessAccountController {

    @Autowired
    private BusinessAccountService businessAccountService;

    @ResponseStatus(code = HttpStatus.FOUND)
    @RequestMapping(value = "/business-account/{qrCode}", method = RequestMethod.GET)
    ResponseEntity<BusinessAccountDto> get(@PathVariable String qrCode) {

        ResponseEntity responseEntity = null;

        if (!qrCode.startsWith("123456")) {
            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("QR-Code inálido");
        } else {
            BusinessAccountDto businessAccountDtoResponse = businessAccountService.findByQrCodeBusinessAccount(qrCode);
            if (businessAccountDtoResponse != null) {
                responseEntity = ResponseEntity.status(HttpStatus.FOUND)
                        .body(businessAccountDtoResponse);
            } else {
                responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("QR-Code não encontrado");
            }
        }
        return responseEntity;
    }

    @PostMapping(value = "/business-account")
    @ResponseStatus(code = HttpStatus.CREATED)
    ResponseEntity<BusinessAccountDto> post(@RequestBody BusinessAccountDto businessAccountDto) {

        ResponseEntity responseEntity = null;

        if (!businessAccountDto.getQrCode().startsWith("123456")) {

            responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("QR-Code inálido");

        } else {

            BusinessAccountDto businessAccountDtoResponse = businessAccountService.saveBusinessAccount(businessAccountDto);

            if (businessAccountDtoResponse != null) {

                responseEntity = ResponseEntity.status(HttpStatus.OK)
                        .body(businessAccountDtoResponse);
            } else {

                responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).body("QR-Code já utilizado");
            }

        }
        return responseEntity;
    }
}
