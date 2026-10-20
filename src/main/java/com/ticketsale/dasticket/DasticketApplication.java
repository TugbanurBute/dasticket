package com.ticketsale.dasticket;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "DasTicket API",
                version = "v1",
                description = "REST API for managing and searching ticketed events."
        )
)
@SpringBootApplication
public class DasticketApplication {

	public static void main(String[] args) {
		SpringApplication.run(DasticketApplication.class, args);
	}

}
