package com.example.acaoSustentavel;

import org.springframework.boot.SpringApplication;

public class TestAcaoSustentavelApplication {

	public static void main(String[] args) {
		SpringApplication.from(AcaoSustentavelApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
