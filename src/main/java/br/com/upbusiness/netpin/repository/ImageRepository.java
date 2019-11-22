package br.com.upbusiness.netpin.repository;

import br.com.upbusiness.netpin.domain.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {

}