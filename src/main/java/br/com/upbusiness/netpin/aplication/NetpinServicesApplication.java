package br.com.upbusiness.netpin.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"br.com.upbusiness.netpin.repository"})
@ComponentScan(basePackages = {"br.com.upbusiness.netpin.controller", "br.com.upbusiness.netpin.service"})
public class NetpinServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetpinServicesApplication.class, args);
    }

}
