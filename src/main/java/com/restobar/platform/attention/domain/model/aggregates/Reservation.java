package com.restobar.platform.attention.domain.model.aggregates;

import com.restobar.platform.attention.domain.model.commands.CreateReservationCommand;
import com.restobar.platform.attention.domain.model.entities.Client;
import com.restobar.platform.attention.domain.model.valueobjects.ClientId;
import com.restobar.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.util.Date;


@Getter
@Entity
public class Reservation extends AuditableAbstractAggregateRoot<Reservation> {

    @NotNull
    @Size(max = 50)
    private String nameRestaurant;

    @Embedded
    private ClientId clientId;

    @NotNull
    private Date dateReservation;

    @NotNull
    private Long countPerson;



    public Reservation(CreateReservationCommand command){
        this.nameRestaurant = Strings.EMPTY;

    }


    public Reservation() {

    }

    public Reservation(String nameRestaurant, ClientId clientId, Date dateReservation, Long countPerson) {
        this.nameRestaurant = nameRestaurant;
        this.clientId = clientId;
        this.dateReservation = dateReservation;
        this.countPerson = countPerson;
    }
}
