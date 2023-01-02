package net.matiello.consumidorregistropontopostgres.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.matiello.consumidorregistropontopostgres.entities.ClockingEventEntity;

@Repository
public interface ClockingEventRespository extends JpaRepository<ClockingEventEntity, UUID> {

}
