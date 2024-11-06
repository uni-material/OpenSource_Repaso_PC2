package com.restobar.platform.attention.application.queryservices;

import com.restobar.platform.attention.domain.model.aggregates.Reservation;
import com.restobar.platform.attention.domain.model.queries.GetAllReservationsQuery;
import com.restobar.platform.attention.domain.model.queries.GetReservationByIdQuery;
import com.restobar.platform.attention.domain.services.ReservationQueryService;
import com.restobar.platform.attention.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {

    private final ReservationRepository reservationRepository;


    public ReservationQueryServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public Optional<Reservation> handle(GetReservationByIdQuery query) {
        return reservationRepository.findById(query.reservationId());
    }

    @Override
    public List<Reservation> handle(GetAllReservationsQuery query) {
        return reservationRepository.findAll();
    }
}
