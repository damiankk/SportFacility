package pl.sportfacility.sportfacility.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;

    @Column(name = "name_reservation")
    @NotNull
    private String nameReservation;

    @Column(name = "sector")
    @NotNull
    private Integer sector;

    @Column(name = "price")
    @NotNull
    private Double price;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    @NotNull
    private Event event;

    @Tolerate
    public Reservation(){
    }
}
