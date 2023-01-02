package net.matiello.consumidorregistropontopostgres.entities;

import java.time.LocalDateTime;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ClockingEventEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private UUID id;

	@Column(nullable = true)
	private UUID employeeId;

	@Column(nullable = true)
	private String employeeCPF;

	@Column(nullable = false)
	private LocalDateTime dateTime;
}
