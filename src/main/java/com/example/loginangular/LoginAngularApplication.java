package com.example.loginangular;

import com.example.loginangular.dao.UserAngularRepository;
import com.example.loginangular.model.User_FrontendAngular;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LoginAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginAngularApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(UserAngularRepository userAngularRepository){
        return args -> {

            List<User_FrontendAngular> allUser = userAngularRepository.findAll();
            System.out.println(allUser);

            userAngularRepository.save(new User_FrontendAngular("startup","springboot"));
            allUser = userAngularRepository.findAll();
            System.out.println(allUser);

        };
    }

}
