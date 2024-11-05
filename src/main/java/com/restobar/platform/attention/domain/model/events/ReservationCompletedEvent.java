package com.restobar.platform.attention.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ReservationCompletedEvent extends ApplicationEvent {

    private final Long reservationId;

    private final Long clientId;

    public ReservationCompletedEvent(Object source, Long reservationId, Long clientId) {
        super(source);
        this.clientId = clientId;
        this.reservationId = reservationId;

    }
}
