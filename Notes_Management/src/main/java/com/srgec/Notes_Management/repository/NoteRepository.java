package com.srgec.Notes_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srgec.Notes_Management.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

}