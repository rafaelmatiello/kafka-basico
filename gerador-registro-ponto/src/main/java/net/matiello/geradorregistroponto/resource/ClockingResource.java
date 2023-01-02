package net.matiello.geradorregistroponto.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.matiello.geradorregistroponto.model.ClockingEvent;
import net.matiello.geradorregistroponto.service.ClockingService;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/clocking")
public class ClockingResource {

    private final ClockingService clockingService;

    @PostMapping
    public ResponseEntity<ClockingEvent> sendClockingEvent(ClockingEvent clocking) {
    	clockingService.sendClockings(clocking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PostMapping(path = "/batch")
    public ResponseEntity<ClockingEvent> sendClockingEventBatch() {
    	clockingService.sendClockingEventBatch();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}