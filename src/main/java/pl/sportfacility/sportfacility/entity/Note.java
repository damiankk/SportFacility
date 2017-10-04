package pl.sportfacility.sportfacility.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;
    @Column(name = "title")
    @NotNull
    private String title;
    @Column(name = "text")
    private String text;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @NotNull
//    private User user;
    @Tolerate
    public Note(){
    }
}
