package se.hig.exte.model;

import java.net.URL;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exam {
	
	/*
	 * Tutorial for making ENTITIES with Spring:
	 * https://spring.io/guides/gs/accessing-data-jpa/
	 * Spring uses the JPA-API which is a part of the Java standard library.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private LocalDate date;
	private URL pdfSource; /* 
							* address to FTP-resource on the form:
							* scheme:[//authority][/path][?query][#fragment]
							* Example: 
							* ftp://theuser:thepassword@someauthority:21
							*/
	
	// Only used for JPA/Spring, which is why it is declared with protected.
	protected Exam() {}
	
	// This constructor is the one we use.
	public Exam(String name, LocalDate date, URL pdfSource) {
		this.name = name;
		this.date = date;
		this.pdfSource = pdfSource;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDate() {
		return date;
	}

	public URL getPdfSource() {
		return pdfSource;
	}
	
	@Override
	public String toString() {
		return "name: " + name + "\nid: " + id + "\nDate: " + date + "\nURL: " + pdfSource;
	}
	
}
