package com.upc.dentify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Clinicnetworkv1Application {

    public static void main(String[] args) {
        SpringApplication.run(Clinicnetworkv1Application.class, args);
    }

}
