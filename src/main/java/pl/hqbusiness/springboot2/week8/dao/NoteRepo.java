package pl.hqbusiness.springboot2.week8.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hqbusiness.springboot2.week8.model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}
