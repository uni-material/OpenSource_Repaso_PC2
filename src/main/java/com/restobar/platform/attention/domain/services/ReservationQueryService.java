package com.restobar.platform.attention.domain.services;

import com.restobar.platform.attention.domain.model.aggregates.Reservation;
import com.restobar.platform.attention.domain.model.queries.GetAllReservationsQuery;
import com.restobar.platform.attention.domain.model.queries.GetReservationByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ReservationQueryService {

    Optional<Reservation> handle(GetReservationByIdQuery query);

    List<Reservation> handle(GetAllReservationsQuery query);

}
