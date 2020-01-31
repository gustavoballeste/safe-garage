package br.com.safegarage.scheduler_service.event.publisher;

import br.com.safegarage.scheduler_service.event.OrderPendingEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderPendingProducer {

    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publish(final OrderPendingEvent orderPendingEvent, final String topic) {
        log.info(String.format(">>>>> Produced kafka message, send scheduler order --> %s", orderPendingEvent));
        try {
            this.kafkaTemplate.send(topic, mapper.writeValueAsString(orderPendingEvent));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), orderPendingEvent);
        }
    }

}
