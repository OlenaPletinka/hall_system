package com.hall_system.hall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HallApplication {

	public static void main(String[] args) {
		SpringApplication.run(HallApplication.class, args);
		System.out.println("Hello word");
	}

}
