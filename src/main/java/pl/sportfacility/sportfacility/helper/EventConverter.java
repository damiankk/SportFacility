package pl.sportfacility.sportfacility.helper;


import pl.sportfacility.sportfacility.dto.EventDto;
import pl.sportfacility.sportfacility.entity.Event;
import pl.sportfacility.sportfacility.exception.Error;
import pl.sportfacility.sportfacility.exception.ErrorSystemException;

public class EventConverter {

    public Event converterToEntity(final EventDto eventDto)  {

        return Event.builder() //
                .description(eventDto.getDescription()) //
                .eventType(eventDto.getEventType()) //
                .title(eventDto.getTitle()) //
                .eventType(eventDto.getEventType()) //
                .freeTicket(eventDto.getFreeTicket())//
                .date(eventDto.getDate())
                .url(eventDto.getUrl())
                .ticket(eventDto.getTicket())
                .build(); //
    }

    public EventDto converterToDto(final Event event){
        return EventDto.builder() //
                .id(event.getId())
                .description(event.getDescription()) //
                .eventType(event.getEventType()) //
                .title(event.getTitle()) //
                .eventType(event.getEventType()) //
                .freeTicket(event.getFreeTicket())//
                .date(event.getDate())
                .url(event.getUrl())
                .ticket(event.getTicket())
                .build(); //
    }


    private PlaceClass getPlaceClass(final int numberClass){
        switch (numberClass) {
            case 1:
                return PlaceClass.FIRST_CLASS;
            case 2:
                return PlaceClass.SECOND_CLASS;
            case 3:
                return PlaceClass.THIRD_CLASS;
            case 4:
                return PlaceClass.FOURTH_CLASS;
            default:
                throw new ErrorSystemException(Error.FATAL_ERROR, "getPlaceClass");
        }
    }

    private int getPlaceClass(final PlaceClass placeClass){
        switch (placeClass) {
            case FIRST_CLASS:
                return 1;
            case SECOND_CLASS:
                return 2;
            case THIRD_CLASS:
                return 3;
            case FOURTH_CLASS:
                return 4;
            default:
                throw new ErrorSystemException(Error.FATAL_ERROR, "getPlaceClass");
        }
    }
}
