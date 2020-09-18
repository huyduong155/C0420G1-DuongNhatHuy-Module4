package notes.service.impl;

import notes.model.NoteType;
import notes.repository.NoteTypeRepository;
import notes.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;
    @Override
    public List<NoteType> findAll() {
        return noteTypeRepository.findAll();
    }
}
