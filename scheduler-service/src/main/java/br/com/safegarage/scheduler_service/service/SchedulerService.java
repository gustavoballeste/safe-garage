package br.com.safegarage.scheduler_service.service;

import static br.com.safegarage.scheduler_service.domain.model.Scheduler.customerEntityToCustomer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.safegarage.scheduler_service.domain.Status;
import br.com.safegarage.scheduler_service.domain.model.Scheduler;
import br.com.safegarage.scheduler_service.entity.SchedulerEntity;
import br.com.safegarage.scheduler_service.event.publisher.OrderPendingPublisher;
import br.com.safegarage.scheduler_service.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    @Autowired
    private SchedulerRepository schedulerRepository;

    @Autowired
    private OrderPendingPublisher orderPendingPublisher;

    public Scheduler create (final Scheduler scheduler) {
        scheduler.setStatus(Status.PENDING);
        final SchedulerEntity savedCustomer = schedulerRepository.save(scheduler.toSchedulerEntity());
        final Scheduler savedScheduler = customerEntityToCustomer(savedCustomer);
        orderPendingPublisher.publishSchedulerEvent(savedScheduler);
        return savedScheduler;
    }

    public List<Scheduler> getAllByCustomer (final Long customerId) {
        return schedulerRepository.findAllByCustomerId(customerId)
                .stream()
                .map(Scheduler::customerEntityToCustomer)
                .collect(Collectors.toList());
    }

    public Optional<SchedulerEntity> getSchedulerEntityById(final Long id) {
        return schedulerRepository.findById(id);
    }

    public boolean updateStatus(final Long id, final String status) {
        final Optional<SchedulerEntity> optionalSchedulerEntity = getSchedulerEntityById(id);
        if (optionalSchedulerEntity.isPresent()) {
            final SchedulerEntity schedulerEntity = optionalSchedulerEntity.get();
            schedulerEntity.setStatus(Status.valueOf(status).toString());
            schedulerRepository.save(schedulerEntity);
            return true;
        } else {
            return false;
        }

    }

}
