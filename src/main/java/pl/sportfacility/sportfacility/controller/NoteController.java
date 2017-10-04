package pl.sportfacility.sportfacility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sportfacility.sportfacility.dto.NoteDto;
import pl.sportfacility.sportfacility.service.NoteServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/note")
public class NoteController {

    private final NoteServiceImpl noteService;

    @Autowired
    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    @PostMapping(value = "/register")
    public HttpEntity<Long> registerNewNote(@RequestBody final NoteDto noteDto) {
        noteService.save(noteDto);

        return new ResponseEntity<Long>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDto> getNotes() {
        return noteService.findAllNote();
    }

    @DeleteMapping(value = "/delete")
    public Long deleteNote(@RequestBody final NoteDto noteDto) {
        noteService.delete(noteDto.getId());

        return noteDto.getId();
    }


}
