package app.bank.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = "app.bank")
@ComponentScan(basePackages = "app.bank")
@EnableJpaRepositories(basePackages = "app.bank.*")
public class GBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(GBankApplication.class, args);
    }

}
