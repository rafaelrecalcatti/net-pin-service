package br.com.upbusiness.netpin.service;

import br.com.upbusiness.netpin.dto.BusinessAccountDto;

import java.util.Collection;

public interface BusinessAccountService {

    public abstract BusinessAccountDto saveBusinessAccount(BusinessAccountDto businessAccountDto);
    public abstract BusinessAccountDto findByQrCodeAndPasswordBusinessAccount(String qrCode, String password);
    public abstract BusinessAccountDto findByQrCodeBusinessAccount(String qrCode);
    public abstract Collection<BusinessAccountDto> findAllBusinessAccount();
}
