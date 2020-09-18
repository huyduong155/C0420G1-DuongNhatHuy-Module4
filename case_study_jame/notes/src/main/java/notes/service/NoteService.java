package notes.service;

import notes.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    Page<Note> findAll(Pageable pageable);
    void save(Note note);
    void remove(int id);
}
