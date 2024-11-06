package com.restobar.platform.attention.interfaces.rest.transfporm;

import com.restobar.platform.attention.domain.model.aggregates.Reservation;
import com.restobar.platform.attention.interfaces.rest.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {

    public static ReservationResource toResourceFromEntity(Reservation entity){

        return new ReservationResource(entity.getId(), entity.getClientId().clientId(), entity.getDateReservation(), entity.getCountPerson());
    }
}
