package br.com.escola;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API-Escola",
				version = "1.0",
				description = "Documentando uma API para aprendizado"

		)
)
public class EscolaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscolaApiApplication.class, args);
	}

}
