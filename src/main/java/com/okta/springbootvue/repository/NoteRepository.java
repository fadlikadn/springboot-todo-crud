package com.okta.springbootvue.repository;

import com.okta.springbootvue.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    /**
     * Now NoteRepository will have ability to call JpaRepository methods like save(), findOne(), findAll(), count(), delete(), etc
     */

}
