package net.matiello.consumidorregistropontomongo.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("clockingEvent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClockingEventEntity {

	@Id
	private String id;

	private String employeeId;
	private String employeeCPF;
	private LocalDateTime dateTime;
}
