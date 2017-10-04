package pl.sportfacility.sportfacility.service;

import pl.sportfacility.sportfacility.dto.ReservationDto;
import pl.sportfacility.sportfacility.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Long save(final ReservationDto reservationDto);

    List<Reservation> findAllReservationUser(Long id);
}
