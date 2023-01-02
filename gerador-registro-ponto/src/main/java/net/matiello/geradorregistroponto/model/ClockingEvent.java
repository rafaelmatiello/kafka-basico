package net.matiello.geradorregistroponto.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE)
@Getter
@RequiredArgsConstructor
public class ClockingEvent implements Serializable {

	UUID id;
	UUID employeeId;
	String employeeCPF;
	LocalDateTime dateTime;
	
}
