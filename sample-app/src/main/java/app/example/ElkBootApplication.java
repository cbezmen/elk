package app.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author cbezmen
 *
 */
@SpringBootApplication
@EnableScheduling
public class ElkBootApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ElkBootApplication.class, args);
	}
}
