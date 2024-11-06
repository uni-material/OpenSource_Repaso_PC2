package com.restobar.platform.attention.interfaces.rest.transfporm;

import com.restobar.platform.attention.domain.model.commands.CreateReservationCommand;
import com.restobar.platform.attention.interfaces.rest.resources.CreateReservationResource;

public class CreateReservationResourceFromEntityAssembler {

    public static CreateReservationCommand toCommandFromResource(CreateReservationResource resource){
        return new CreateReservationCommand(resource.nameRestaurant(), resource.clientId(), resource.dateReservation(),resource.countPerson());
    }
}
