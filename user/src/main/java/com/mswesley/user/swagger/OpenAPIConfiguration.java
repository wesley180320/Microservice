package com.mswesley.user.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        io.swagger.v3.oas.models.servers.Server server = new Server();
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Wesley Souza");
        myContact.setEmail("estevaoowesley@gmail.com");

        Info information = new Info()
                .title("SERVIÇO DE ENVIO DE EMAILS UTILIZANDO RABBITMQ")
                .version("1.0")
                .description("Urls de envio de Emails")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
