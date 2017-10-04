package pl.sportfacility.sportfacility.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_class")
    private Integer firstClass;

    @Column(name = "second_class")
    private Integer secondClass;

    @Column(name = "third_class")
    private Integer thirdClass;

    @Column(name = "fourth_class")
    private Integer fourthClass;

    @Column(name = "price")
    private Double price;

    @OneToOne(cascade = CascadeType.ALL)
    private Event event;

    @Tolerate
    public Ticket() {
    }
}
