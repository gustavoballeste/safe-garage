package br.com.safegarage.scheduler_service.event.publisher;

import br.com.safegarage.scheduler_service.domain.model.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderPendingPublisher {

    @Autowired
    private OrderPendingProducer orderPendingProducer;

    @Value("${kafka.customer-scheduler-requested.topic}")
    private String topic;

    public void publishSchedulerEvent (final Scheduler scheduler) {
        orderPendingProducer.publish(scheduler.toSchedulerEvent(), topic);
    }

}
