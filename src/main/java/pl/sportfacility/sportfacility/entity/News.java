package pl.sportfacility.sportfacility.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Builder
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;
    @Column(name = "title")
    @NotNull
    private String title;
    @Column(name = "date")
    @NotNull
    private Date date;
    @Column(name = "description")
    private String description;

}
