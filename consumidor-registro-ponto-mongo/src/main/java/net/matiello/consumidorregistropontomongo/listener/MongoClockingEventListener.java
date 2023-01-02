package net.matiello.consumidorregistropontomongo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.matiello.consumidorregistropontomongo.entities.ClockingEventEntity;
import net.matiello.consumidorregistropontomongo.model.ClockingEvent;
import net.matiello.consumidorregistropontomongo.service.ClockingEventService;

@Log4j2
@Component
@RequiredArgsConstructor
public class MongoClockingEventListener {

	final ClockingEventService service;

	@KafkaListener(topics = "clocking-topic",//
			groupId = "mongo-group",//			
			containerFactory = "jsonContainerFactory", autoStartup = "true")
	public void consumer(@Payload ClockingEvent payload) {
		log.info("Consumindo clocking {}", payload.toString());

		var entity = new ClockingEventEntity();
		entity.setId(payload.getId().toString());
		entity.setDateTime(payload.getDateTime());
		entity.setEmployeeCPF(payload.getEmployeeCPF());
		entity.setEmployeeId(payload.getEmployeeId().toString());
		service.save(entity);
	}

}