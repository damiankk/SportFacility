package pl.sportfacility.sportfacility.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
public class ReservationDto {

    private String name;
    private Long idAccount;
    private Long idEvent;
    private Integer sector;
    private Integer pieces;
    private Double price;

    @Tolerate
    public ReservationDto(){
    }
}
