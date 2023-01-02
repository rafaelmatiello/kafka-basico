package net.matiello.consumidorregistropontomongo.repository;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.matiello.consumidorregistropontomongo.entities.ClockingEventEntity;

@Repository
public interface ClockingEventRespository extends MongoRepository<ClockingEventEntity, UUID> {

}