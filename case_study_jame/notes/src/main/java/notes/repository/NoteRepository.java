package notes.repository;

import notes.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {
    @Query(value = "select * from note where  delete_note = 0",nativeQuery = true)
    Page<Note> findAll(Pageable pageable);
    @Modifying
    @Transactional
    @Query(value="update note set delete_note = 1 where id = ?;",nativeQuery = true)
    void deleteNote(int id);
}
