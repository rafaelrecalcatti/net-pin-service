package br.com.upbusiness.netpin.repository;

import br.com.upbusiness.netpin.domain.BusinessAccount;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusinessAccountRepository extends MongoRepository<BusinessAccount, String> {

    /**
     * Encontra a conta empresarial pelo QRCode.
     *
     * @param qrCode
     * @return lista de livros
     */
    BusinessAccount findByQrCode(String qrCode);

    BusinessAccount findByQrCodeAndPassword(String qrCode, String password);
}