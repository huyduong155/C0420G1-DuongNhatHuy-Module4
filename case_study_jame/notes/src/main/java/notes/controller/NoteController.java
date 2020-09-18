package notes.controller;

import notes.model.Note;
import notes.model.NoteType;
import notes.service.NoteService;
import notes.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteTypeService noteTypeService;

    @GetMapping("/")
    public ModelAndView listNote(@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("listNote");
        Page<Note> notes = noteService.findAll(pageable);
        List<NoteType> noteTypes = noteTypeService.findAll();
        modelAndView.addObject("notes",notes);
        modelAndView.addObject("noteTypes",noteTypes);
        modelAndView.addObject("note",new Note());
         return modelAndView;
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute("note")Note note, RedirectAttributes redirectAttributes){
        noteService.save(note);
        redirectAttributes.addFlashAttribute("success", "Saved new note successfully!");
        return"redirect:/";
    }
    @PostMapping("/edit")
    public String editNote(Note note,RedirectAttributes redirectAttributes){
        noteService.save(note);
        redirectAttributes.addFlashAttribute("success", "Modified note successfully!");
        return"redirect:/";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") int id,RedirectAttributes redirectAttributes){
        noteService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Delete note successfully!");
        return"redirect:/";
    }
}