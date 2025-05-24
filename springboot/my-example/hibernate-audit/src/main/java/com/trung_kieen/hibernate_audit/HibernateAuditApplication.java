package com.trung_kieen.hibernate_audit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.trung_kieen.hibernate_audit.entity.Note;
import com.trung_kieen.hibernate_audit.repository.NoteRepository;

@SpringBootApplication
@EnableJpaAuditing
public class HibernateAuditApplication implements CommandLineRunner {
  @Autowired 
  private NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateAuditApplication.class, args);
	}

  @Override
  public void run(String... args) throws Exception {
    var note = Note.builder()
    .title("NOTE TITLE ")
    .content("NOTE content")
    .build();
    var cat = note;
    System.out.println(cat);
    noteRepository.save(cat);

  }

}
