package com.mongo;

import com.mongo.documents.Student;
import com.mongo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MongoPracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongoPracticeApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		studentRepository.saveAll(List.of(
				new Student("Ower", "Erden", 90),
				new Student("Ower", "Erden2",89),
				new Student("Ower", "Erden3",50),
				new Student("Ower", "Erden4",45),
				new Student("Ower", "Erden5", 92),
				new Student("Ower", "Erden6",30),
				new Student("Ower", "Erden7", 10),
				new Student("Ower", "Erden8", 70),
				new Student("Ower", "Erden9", 65)
		));
	}
}
