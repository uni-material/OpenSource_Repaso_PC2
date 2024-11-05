package com.restobar.platform.attention.domain.model.aggregates;

import com.restobar.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.util.Date;

public class Reservation extends AuditableAbstractAggregateRoot<Reservation> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String nameRestaurant;

    @Getter
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Long clientId;

    @NotNull
    private Date dateReservation;

    @NotNull
    private Long countPerson;


    public Reservation(String nameRestaurant, Long clientId, Date dateReservation, Long countPerson) {
        this.nameRestaurant = nameRestaurant;
        this.clientId = clientId;
        this.dateReservation = dateReservation;
        this.countPerson = countPerson;
    }

    public Reservation(){
        this.nameRestaurant = Strings.EMPTY;

    }


}
