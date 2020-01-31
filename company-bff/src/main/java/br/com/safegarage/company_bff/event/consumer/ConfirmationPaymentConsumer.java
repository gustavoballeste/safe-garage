package br.com.safegarage.company_bff.event.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConfirmationPaymentConsumer {

    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @KafkaListener(topics = "${kafka.customer-scheduler-requested.topic}", groupId = "group_id")
    public void consume(final String message) {
        log.info(String.format("<<<<< Consumed message <- %s", message));
        OrderPendingEvent orderPendingEvent = null;
        try {
            orderPendingEvent = mapper.readValue(message, OrderPendingEvent.class);
            //TODO Enviar notificação
            //TODO Enviar evento no Slack
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), message);
        }
    }

}