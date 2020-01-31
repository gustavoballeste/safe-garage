package br.com.safegarage.customer_bff.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.safegarage.customer_bff.domain.Status;
import br.com.safegarage.customer_bff.domain.model.Scheduler;
import br.com.safegarage.customer_bff.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    @Autowired
    private SchedulerRepository schedulerRepository;

    public Scheduler create (final Scheduler scheduler) {
        final AssistanceSchedulerEntity savedCustomer = schedulerRepository.save(scheduler.toSchedulerEntity());
        return Scheduler.customerEntityToCustomer(savedCustomer);
    }

    public List<Scheduler> getAllByCustomer (final Long customerId) {
        return schedulerRepository.findAllByCustomerId(customerId)
                .stream()
                .map(Scheduler::customerEntityToCustomer)
                .collect(Collectors.toList());
    }

    public Optional<AssistanceSchedulerEntity> getSchedulerEntityById(final Long id) {
        return schedulerRepository.findById(id);
    }

    public boolean confirm (final Long id) {
        return changeStatus(id, Status.CONFIRMED);
    }

    public boolean cancel (final Long id) {
        return changeStatus(id, Status.CANCELED);
    }

    private boolean changeStatus (final Long id, final Status status) {
        final Optional<AssistanceSchedulerEntity> optionalSchedulerEntity = getSchedulerEntityById(id);
        if (optionalSchedulerEntity.isPresent()) {
            final AssistanceSchedulerEntity schedulerEntity = optionalSchedulerEntity.get();
            schedulerEntity.setStatus(status);
            schedulerRepository.save(schedulerEntity);
            return true;
        } else {
            return false;
        }
    }

}
