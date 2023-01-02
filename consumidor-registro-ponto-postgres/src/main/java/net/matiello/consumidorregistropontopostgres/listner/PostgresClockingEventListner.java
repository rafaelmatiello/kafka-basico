package net.matiello.consumidorregistropontopostgres.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.matiello.consumidorregistropontopostgres.entities.ClockingEventEntity;
import net.matiello.consumidorregistropontopostgres.model.ClockingEvent;
import net.matiello.consumidorregistropontopostgres.service.ClockingEventService;

@Log4j2
@Component
@RequiredArgsConstructor
public class PostgresClockingEventListner {

	final ClockingEventService service;

	@KafkaListener(topics = "clocking-topic", groupId = "postgress-group", containerFactory = "jsonContainerFactory", autoStartup = "true")
	public void consumer(@Payload ClockingEvent payload) {
		log.info("Consumindo clocking {}", payload.toString());

		ClockingEventEntity entity = new ClockingEventEntity();
		entity.setId(payload.getId());
		entity.setDateTime(payload.getDateTime());
		entity.setEmployeeCPF(payload.getEmployeeCPF());
		entity.setEmployeeId(payload.getEmployeeId());
		service.save(entity);
	}

}
