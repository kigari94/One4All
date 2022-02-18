package com.haw.one4all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EmbeddedId;

@SpringBootApplication
@RestController
public class One4allApplication {

	public static void main(String[] args) {
		SpringApplication.run(One4allApplication.class, args);
	}


}
