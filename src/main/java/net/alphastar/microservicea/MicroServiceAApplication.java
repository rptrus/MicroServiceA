package net.alphastar.microservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MicroServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceAApplication.class, args);
    }

}
