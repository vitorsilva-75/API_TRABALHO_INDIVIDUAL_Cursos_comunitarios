package org.serratec.Trabindividual.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI myOpenAPI() {
		Contact contato = new Contact()
		contato.setEmail("vitor.silva@residente.serratec.org.br");
		contato.setName("Vitor Ribeiro");
		contato.url("https://serratec.org/");
		
		License apacheLicense = new License()
				.name("Apache License")
				.url("https://www.apache.org/licenses/LICENSE-2.0");
		
		Info info = new Info()
				.title("API de Cursos comunitários")
				.version("1.0")
				.contact(contato)
				.description("Api para sistema de cursos comunitários com cadastro de alunos, professores, discplinas e perfil social.")
				.termsOfService("https://serratec.org/")
				.license(apacheLicense);
		
		return new OpenAPI().info(info);
	}
}
