package edu.mum.cs.cs425.e.registrar;

import edu.mum.cs.cs425.e.registrar.Services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner seedDB(StudentService studentService) {
		return args -> {
			studentService.seedDb();
		};
	}

}
