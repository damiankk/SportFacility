package pl.sportfacility.sportfacility.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "event_type")
public class EventType {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @OneToMany(mappedBy = "eventType",cascade = CascadeType.ALL)
    private List<Event> events;

}
