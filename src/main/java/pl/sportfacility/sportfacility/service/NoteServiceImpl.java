package pl.sportfacility.sportfacility.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sportfacility.sportfacility.dto.NoteDto;
import pl.sportfacility.sportfacility.entity.Note;
import pl.sportfacility.sportfacility.helper.NoteConverter;
import pl.sportfacility.sportfacility.repository.NoteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteConverter noteConverter;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
        this.noteConverter = new NoteConverter();
    }

    @Override
    public Long save(final NoteDto noteDto) {
        final Note note = noteConverter.convertDtoToEntity(noteDto);
        noteRepository.save(note);

        return note.getId();
    }

    @Override
    public Long delete(Long id) {
        Note note = noteRepository.findById(id);
        noteRepository.delete(note);

        return note.getId();
    }


    @Override
    public List<NoteDto> findAllNote() {
        return noteRepository.findAll().stream()
                .map(this::getDto)
                .collect(Collectors.toList());
    }

    private NoteDto getDto(final Note note){
        return noteConverter.convertEntityToDto(note);
    }
}

/*
    private EventDto getDto(final Event event){
        return eventConverter.converterToDto(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        return eventRepository.findAll().stream() //
                .map(this::getDto) //
                .collect(Collectors.toList()); //
    }
 */