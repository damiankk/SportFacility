package pl.sportfacility.sportfacility.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class NewsDto {

    private Long id;
    private String title;
    private Date date;
    private String description;
}
