package com.codefrombasics.java_spring_mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.codefrombasics.java_spring_mongo.*"})

public class JavaSpringMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringMongoApplication.class, args);
	}

}
