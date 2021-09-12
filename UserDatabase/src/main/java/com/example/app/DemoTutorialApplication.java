package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoTutorialApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoTutorialApplication.class, args);
	}

}
