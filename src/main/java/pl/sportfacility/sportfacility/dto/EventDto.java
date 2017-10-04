package pl.sportfacility.sportfacility.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sportfacility.sportfacility.entity.EventType;
import pl.sportfacility.sportfacility.entity.Ticket;

import java.util.Date;

@Data
@Builder
public class EventDto {

    private Long id;
    private String title;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date date;
    private String description;
    private String url;
    private EventType eventType;
    private int freeTicket;
    private Ticket ticket;

    @Tolerate
    public EventDto(){
    }
}
