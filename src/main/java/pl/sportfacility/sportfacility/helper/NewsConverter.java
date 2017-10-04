package pl.sportfacility.sportfacility.helper;

import pl.sportfacility.sportfacility.dto.NewsDto;
import pl.sportfacility.sportfacility.entity.News;

public class NewsConverter {

    public NewsConverter(){
    }

    public News convertDtoToEntity(final NewsDto newsDto){
        return News.builder()
                .id(newsDto.getId())
                .title(newsDto.getTitle())
                .date(newsDto.getDate())
                .description(newsDto.getDescription())
                .build();
    }

    public NewsDto convertEntityToDto(final News news){
        return NewsDto.builder()
                .id(news.getId())
                .title(news.getTitle())
                .date(news.getDate())
                .description(news.getDescription())
                .build();
    }

}
