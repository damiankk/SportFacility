package pl.sportfacility.sportfacility.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import pl.sportfacility.sportfacility.entity.Account;

@Data
@Builder
public class NoteDto {

    private Long id;
    private String title;
    private String text;
    private Account account;

    @Tolerate
    public NoteDto(){
    }
}
