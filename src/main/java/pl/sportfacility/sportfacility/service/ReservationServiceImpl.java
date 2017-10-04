package pl.sportfacility.sportfacility.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sportfacility.sportfacility.dto.ReservationDto;
import pl.sportfacility.sportfacility.entity.Account;
import pl.sportfacility.sportfacility.entity.Event;
import pl.sportfacility.sportfacility.entity.Reservation;
import pl.sportfacility.sportfacility.exception.Error;
import pl.sportfacility.sportfacility.exception.ErrorSystemException;
import pl.sportfacility.sportfacility.repository.ReservationRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final EventServiceImpl eventService;
    private final AccountServiceImpl accountService;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, EventServiceImpl eventService, AccountServiceImpl accountService) {
        this.reservationRepository = reservationRepository;
        this.eventService = eventService;
        this.accountService = accountService;
    }


    @Override
    public Long save(final ReservationDto reservationDto) {
        final Reservation reservation = prepareReservation(reservationDto);
        reservationRepository.save(reservation);

        return 1L;
    }

    @Override
    public List<Reservation> findAllReservationUser(final Long id) {
        final List<Reservation> reservations = reservationRepository.findAll();

        return reservations.stream()
                .filter(r -> r.getAccount().getId().equals(id))
                .collect(Collectors.toList());
    }

    public Reservation prepareReservation(final ReservationDto reservationDto) {
        final Account account = accountService.findById(reservationDto.getIdAccount());
        final Event event = eventService.findById(reservationDto.getIdEvent());

        changeValue(event, reservationDto.getSector(), reservationDto.getPieces());

        return Reservation.builder()//
                .account(account)//
                .event(event)//
                .nameReservation(reservationDto.getName())
                .price(reservationDto.getPrice())
                .sector(reservationDto.getSector())
                .build();

    }

    private Event changeValue(final Event event, int sector, int pieces) { //aktualizuje ilosc biletow w tabelach dla rezerwowanego eventu
        switch (sector) {
            case 1:
                event.getTicket().setFirstClass(event.getTicket().getFirstClass() - pieces);
                event.setFreeTicket(event.getFreeTicket()- pieces);
                return event;
            case 2:
                event.getTicket().setSecondClass(event.getTicket().getSecondClass() - pieces);
                event.setFreeTicket(event.getFreeTicket()- pieces);
                return event;
            case 3:
                event.getTicket().setThirdClass(event.getTicket().getThirdClass() - pieces);
                event.setFreeTicket(event.getFreeTicket()- pieces);
                return event;
            case 4:
                event.getTicket().setFourthClass(event.getTicket().getFourthClass() - pieces);
                event.setFreeTicket(event.getFreeTicket()- pieces);
                return event;
            default:
                throw new ErrorSystemException(Error.FATAL_ERROR, "changeValue");
        }

    }
}
