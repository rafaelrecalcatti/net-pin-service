package br.com.upbusiness.netpin.service;

import br.com.upbusiness.netpin.domain.BusinessAccount;
import br.com.upbusiness.netpin.dto.BusinessAccountDto;
import br.com.upbusiness.netpin.repository.BusinessAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BusinessAccountServiceImpl implements BusinessAccountService {

    @Autowired
    private BusinessAccountRepository businessAccountRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public BusinessAccountDto saveBusinessAccount(BusinessAccountDto businessAccountDto) {

        BusinessAccountDto businessAccountDtoResponse = null;

        try {

            businessAccountDtoResponse = modelMapper.map(businessAccountRepository.save(modelMapper.map(businessAccountDto, BusinessAccount.class)), BusinessAccountDto.class);

        } catch (Exception e) {
        }

        return businessAccountDtoResponse;
    }

    @Override
    public BusinessAccountDto findByQrCodeAndPasswordBusinessAccount(String qrCode, String password) {
        return modelMapper.map(businessAccountRepository.findByQrCodeAndPassword(qrCode, password), BusinessAccountDto.class);
    }

    @Override
    public BusinessAccountDto findByQrCodeBusinessAccount(String qrCode) {
        return modelMapper.map(businessAccountRepository.findByQrCode(qrCode), BusinessAccountDto.class);
    }

    @Override
    public Collection<BusinessAccountDto> findAllBusinessAccount() {
        return null;
    }
}
