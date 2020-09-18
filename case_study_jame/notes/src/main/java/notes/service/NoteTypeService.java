package notes.service;

import notes.model.NoteType;

import java.util.List;

public interface NoteTypeService {
    List<NoteType> findAll();
}
