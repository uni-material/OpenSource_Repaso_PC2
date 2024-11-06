package com.restobar.platform.attention.application.commandservices;

import com.restobar.platform.attention.domain.model.aggregates.Reservation;
import com.restobar.platform.attention.domain.model.commands.CreateReservationCommand;
import com.restobar.platform.attention.domain.model.commands.DeleteReservationCommand;
import com.restobar.platform.attention.domain.services.ReservationCommandService;
import com.restobar.platform.attention.infrastructure.persistence.jpa.repositories.ReservationRepository;
import jakarta.persistence.MappedSuperclass;
import org.springframework.stereotype.Service;

@Service
@MappedSuperclass
public class ReservationCommandServiceImpl implements ReservationCommandService {

    private ReservationRepository reservationRepository;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public Long handle(CreateReservationCommand command) {

        if(reservationRepository.existByClientId(command.clientId())){
            throw new IllegalArgumentException("Reservation with same id already exists");
        }

        if(reservationRepository.existsByNameRestaurant(command.nameRestaurant())){
            throw new IllegalArgumentException("Reservation with same restaurant name cannot exist");
        }

        var reservation = new Reservation(command);
        try{
            reservationRepository.save(reservation);
        }catch (Exception exception){
            throw new IllegalArgumentException("Error while saving reservation " + exception.getMessage());
        }
        return reservation.getId();
    }

    @Override
    public void handle(DeleteReservationCommand command) {
        if(!reservationRepository.existsById(command.reservationId())){
            throw new IllegalArgumentException("Reservation does not exist");
        }

        try {
            reservationRepository.deleteById(command.reservationId());
        }catch (Exception exception){
            throw new IllegalArgumentException("Error while deleting reservation: " + exception.getMessage());
        }

    }
}
