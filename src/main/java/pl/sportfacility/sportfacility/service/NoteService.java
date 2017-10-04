package pl.sportfacility.sportfacility.service;

import pl.sportfacility.sportfacility.dto.NoteDto;

import java.util.List;

public interface NoteService {

    Long save(final NoteDto noteDto);

    Long delete(final Long id);

    List<NoteDto> findAllNote();

}
