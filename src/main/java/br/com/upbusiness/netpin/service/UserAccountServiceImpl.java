package br.com.upbusiness.netpin.service;

import br.com.upbusiness.netpin.domain.UserAccount;
import br.com.upbusiness.netpin.dto.BusinessAccountDto;
import br.com.upbusiness.netpin.dto.UserAccountDto;
import br.com.upbusiness.netpin.repository.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Override
    public UserAccountDto createUserAccount(UserAccountDto userAccountDto) {
       UserAccount userAccount = userAccountRepository.save(modelMapper.map(userAccountDto, UserAccount.class));
       return modelMapper.map(userAccount, UserAccountDto.class);
    }

    @Override
    public void updateUserAccount(UserAccountDto userAccountDto) {

    }

    @Override
    public UserAccountDto findByUserAccount(String email, String password) {
        UserAccountDto userAccount = null;
        try {
            userAccount = modelMapper.map(userAccountRepository.findByEmailAndPassword(email, password), UserAccountDto.class);
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return userAccount;
    }

    @Override
    public UserAccountDto findById(String id) {
        return modelMapper.map(userAccountRepository.findById(id), UserAccountDto.class);
    }
}
