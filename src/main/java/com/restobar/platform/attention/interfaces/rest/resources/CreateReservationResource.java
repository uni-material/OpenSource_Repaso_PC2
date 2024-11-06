package com.restobar.platform.attention.interfaces.rest.resources;

import java.util.Date;

public record CreateReservationResource(String nameRestaurant, Long clientId, Date dateReservation, Long countPerson) {
}
