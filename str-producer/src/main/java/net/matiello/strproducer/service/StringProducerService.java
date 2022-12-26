package net.matiello.strproducer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringProducerService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		kafkaTemplate.send("str-topic", message).addCallback(success -> {
			if (success != null) {
				log.info("Send message with sucess {},", message);
				log.info("Partition {}, OffSet {}", success.getRecordMetadata().partition(),
						success.getRecordMetadata().offset());
			}
		}, error -> log.error("Error send a message"));
	}

}
