package br.com.upbusiness.netpin.service;

import br.com.upbusiness.netpin.dto.UserAccountDto;

public interface UserAccountService{

    public abstract UserAccountDto createUserAccount(UserAccountDto userAccountDto);
    public abstract void updateUserAccount(UserAccountDto userAccountDto);
    public abstract UserAccountDto findByUserAccount(String email, String password);
    public abstract UserAccountDto findById(String id);

}
