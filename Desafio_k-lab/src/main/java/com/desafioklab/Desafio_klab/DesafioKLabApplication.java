package com.desafioklab.Desafio_klab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioKLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioKLabApplication.class, args);
	}

}
