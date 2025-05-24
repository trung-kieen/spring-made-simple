package com.trung_kieen.hibernate_audit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trung_kieen.hibernate_audit.entity.Note;
import com.trung_kieen.hibernate_audit.repository.NoteRepository;

/**
 * RecentController
 */
@RestController
@RequestMapping("/api/recent")
public class RecentController {

  @Autowired
  private NoteRepository noteRepository;

  @GetMapping
  public Iterable<Note> recent() {

    PageRequest page = PageRequest.of(0, 12, Sort.by("createAt").descending());
    var notePages = noteRepository.findAll(page);

    return notePages.getContent();

  }

}
