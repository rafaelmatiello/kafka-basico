package net.matiello.consumidorregistropontomongo.service;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.matiello.consumidorregistropontomongo.entities.ClockingEventEntity;
import net.matiello.consumidorregistropontomongo.repository.ClockingEventRespository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClockingEventService {

	final ClockingEventRespository repository;

	public ClockingEventEntity save(ClockingEventEntity entity) {
		return repository.save(entity);
	}

}