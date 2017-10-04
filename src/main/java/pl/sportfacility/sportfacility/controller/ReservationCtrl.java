package pl.sportfacility.sportfacility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sportfacility.sportfacility.dto.ReservationDto;
import pl.sportfacility.sportfacility.entity.Reservation;
import pl.sportfacility.sportfacility.service.ReservationServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationCtrl {

    private final ReservationServiceImpl reservationService;

    @Autowired
    public ReservationCtrl(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(value = "/add")
    public void createReservation(@RequestBody final ReservationDto reservationDto){
       reservationService.save(reservationDto);
    }

    @PostMapping(value = "/all")
    public List<Reservation> getAllUserReservation(@RequestBody final ReservationDto reservationDto){
        return reservationService.findAllReservationUser(reservationDto.getIdAccount());
    }
}
