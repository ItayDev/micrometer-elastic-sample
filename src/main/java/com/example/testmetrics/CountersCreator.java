package com.example.testmetrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountersCreator {
    MeterRegistry registry;

    @Scheduled(fixedRate = 1000)
    public void generateMetrics() {
        Counter sampleCounter = registry.counter("itsACounter", "informative", "tag");
        log.info("Counter value is: {}", sampleCounter.count());
        sampleCounter.increment();
    }
}
