package rs.ac.bg.fon.ai.naprednoProgramiranje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import rs.ac.bg.fon.ai.naprednoProgramiranje.config.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class NaprednoProgramiranjeApplication {

	public static void main(String[] args) {

		SpringApplication.run(NaprednoProgramiranjeApplication.class, args);
	}

}
