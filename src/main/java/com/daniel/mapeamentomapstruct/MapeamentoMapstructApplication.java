package com.daniel.mapeamentomapstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class MapeamentoMapstructApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapeamentoMapstructApplication.class, args);
	}

}
