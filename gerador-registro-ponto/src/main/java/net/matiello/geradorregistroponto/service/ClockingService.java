package net.matiello.geradorregistroponto.service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.matiello.geradorregistroponto.model.ClockingEvent;
import net.matiello.geradorregistroponto.utils.CpfUtils;

@RequiredArgsConstructor
@Service
public class ClockingService {

	private static final int ITENS_BY_EMPLOYEE = 4;
	private final KafkaTemplate<String, Serializable> kafkaTemplate;

	public void sendClockings(ClockingEvent clockingEvent) {
		kafkaTemplate.send("clocking-topic", clockingEvent);
	}

	public void sendClockingEventBatch() {

		UUID employeeId = UUID.randomUUID();
		String employeeCpf = CpfUtils.random();
		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		for (int i = 0; i < 5 * ITENS_BY_EMPLOYEE; i++) {

			if (i % 4 == 0) {
				employeeId = UUID.randomUUID();
				employeeCpf = CpfUtils.random();
			}

			LocalDateTime dateTime = LocalDateTime.now()//
					.withHour(threadLocalRandom.nextInt(23))//
					.withMinute(threadLocalRandom.nextInt(59));

			ClockingEvent clocking = new ClockingEvent(UUID.randomUUID(), employeeId, employeeCpf, dateTime);
			
			sendClockings(clocking);
		}
	}
}
