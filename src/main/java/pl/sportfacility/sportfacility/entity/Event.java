package pl.sportfacility.sportfacility.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Builder
@Data
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "free_ticket")
    private int freeTicket;

    @Column(name = "url")
    private String url;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "place_id")
//    @JsonIgnore
//    @NotNull
//    private Place place;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventType_id")
    @JsonIgnore
    @NotNull
    private EventType eventType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id")
    @JsonIgnore
    @NotNull
    private Ticket ticket;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

    @Tolerate
    public Event(){
    }
}
