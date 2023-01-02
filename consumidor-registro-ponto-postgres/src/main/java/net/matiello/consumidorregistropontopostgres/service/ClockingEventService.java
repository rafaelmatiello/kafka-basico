package net.matiello.consumidorregistropontopostgres.service;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.matiello.consumidorregistropontopostgres.entities.ClockingEventEntity;
import net.matiello.consumidorregistropontopostgres.repository.ClockingEventRespository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClockingEventService {

	final ClockingEventRespository repository;

	public ClockingEventEntity save(ClockingEventEntity entity) {
		return repository.save(entity);
	}

}
