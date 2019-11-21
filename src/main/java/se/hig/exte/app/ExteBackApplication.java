package se.hig.exte.app;

import java.net.URL;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import se.hig.exte.model.Exam;
import se.hig.exte.repository.ExamRepository;

@SpringBootApplication
public class ExteBackApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ExteBackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExteBackApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ExamRepository repo) {
		return (args) -> {
			repo.save(new Exam("Exam1", LocalDate.now(), new URL("http://www.hej.se")));
			repo.save(new Exam("Exam2", LocalDate.now(), new URL("http://www.hej.se")));
			repo.save(new Exam("Exam3", LocalDate.now(), new URL("http://www.hej.se")));

			log.info("Exams found with findAll():");
			log.info("-------------------------------");
			for (Exam exam : repo.findAll()) {
				log.info(exam.toString());
			}
			log.info("");

			Exam exam = repo.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(exam.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repo.findByName("Exam1").forEach(someExam -> {
				log.info(someExam.toString());
			});
			log.info("");
		};
	}
	
}
