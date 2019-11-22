package br.com.upbusiness.netpin.repository;

import br.com.upbusiness.netpin.domain.UserAccount;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    UserAccount findByEmailAndPassword(String email, String password);
}