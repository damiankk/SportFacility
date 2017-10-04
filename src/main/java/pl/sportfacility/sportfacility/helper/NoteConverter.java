package pl.sportfacility.sportfacility.helper;

import pl.sportfacility.sportfacility.dto.NoteDto;
import pl.sportfacility.sportfacility.entity.Note;

public class NoteConverter {

    public NoteConverter(){

    }

    public Note convertDtoToEntity(final NoteDto noteDto){
        return Note.builder()
                .id(noteDto.getId())
                .title(noteDto.getTitle())
                .text(noteDto.getText())
                .build();
    }

    public NoteDto convertEntityToDto(final Note note){
        return NoteDto.builder()
                .id(note.getId())
                .title(note.getTitle())
                .text(note.getText())
                .build();
    }
}