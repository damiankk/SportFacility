package pl.sportfacility.sportfacility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sportfacility.sportfacility.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Note findById(Long id);

}
