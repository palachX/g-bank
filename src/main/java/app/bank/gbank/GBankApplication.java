package app.bank.gbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class GBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(GBankApplication.class, args);
    }

}
