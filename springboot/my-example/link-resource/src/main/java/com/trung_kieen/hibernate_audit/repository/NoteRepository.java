package com.trung_kieen.hibernate_audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.trung_kieen.hibernate_audit.entity.Note;

/**
 * NoteRepository
 */
@Repository
public interface NoteRepository  extends JpaRepository<Note, Long>  {



}
