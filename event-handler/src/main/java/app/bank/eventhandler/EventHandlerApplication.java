package app.bank.eventhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "app.bank")
@ComponentScan(basePackages = "app.bank")
@EnableJpaRepositories(basePackages = "app.bank.*")
public class EventHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventHandlerApplication.class, args);
	}

}
