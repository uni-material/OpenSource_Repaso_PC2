package com.restobar.platform.attention.interfaces.rest;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.restobar.platform.attention.domain.model.queries.GetReservationByIdQuery;
import com.restobar.platform.attention.domain.services.ReservationCommandService;
import com.restobar.platform.attention.domain.services.ReservationQueryService;
import com.restobar.platform.attention.interfaces.rest.resources.CreateReservationResource;
import com.restobar.platform.attention.interfaces.rest.resources.ReservationResource;
import com.restobar.platform.attention.interfaces.rest.transfporm.CreateReservationResourceFromEntityAssembler;
import com.restobar.platform.attention.interfaces.rest.transfporm.ReservationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/reservations", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Resources", description = "Resource Management Endpoints")

public class ReservationsController {

    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;


    public ReservationsController(ReservationCommandService reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    /**
     * Create a new Reservation
     */
    @PostMapping
    public ResponseEntity<ReservationResource> createReservation(@RequestBody CreateReservationResource createReservationResource){
        var createReservationCommand = CreateReservationResourceFromEntityAssembler.toCommandFromResource(createReservationResource);
        var reservationId = reservationCommandService.handle(createReservationCommand);
        if(reservationId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getReservationByIdQuery = new GetReservationByIdQuery(reservationId);
        var reservation = reservationQueryService.handle(getReservationByIdQuery);
        if(reservation.isEmpty()) return ResponseEntity.badRequest().build();

        var reservationResource = ReservationResourceFromEntityAssembler.toResourceFromEntity(reservation.get());
        return new ResponseEntity<>(reservationResource, HttpStatus.CREATED);



    }


}
