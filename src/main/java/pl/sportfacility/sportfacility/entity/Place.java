package pl.sportfacility.sportfacility.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import pl.sportfacility.sportfacility.helper.PlaceClass;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private PlaceClass name;

//    @OneToMany(mappedBy = "place",cascade = CascadeType.ALL)
//    private List<Event> events;

    @Tolerate
    public Place(){
    }
}
