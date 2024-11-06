package com.restobar.platform.attention.domain.services;

import com.restobar.platform.attention.domain.model.commands.CreateReservationCommand;
import com.restobar.platform.attention.domain.model.commands.DeleteReservationCommand;

public interface ReservationCommandService {

    Long handle(CreateReservationCommand command);

    void handle(DeleteReservationCommand command);

}
