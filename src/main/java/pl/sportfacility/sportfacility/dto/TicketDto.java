package pl.sportfacility.sportfacility.dto;

import lombok.Data;
import pl.sportfacility.sportfacility.entity.Account;
import pl.sportfacility.sportfacility.entity.Event;
import pl.sportfacility.sportfacility.entity.Account;

@Data
public class TicketDto {

    private Long id;
    private Event event;
    private Integer seat;
    private Account account;
}
