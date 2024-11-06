package com.restobar.platform.attention.infrastructure.persistence.jpa.repositories;

import com.restobar.platform.attention.domain.model.aggregates.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findByClientId(Long clientId);

    boolean existByClientId(Long clientId);

    boolean existsByNameRestaurant(String restaurantName);



}
