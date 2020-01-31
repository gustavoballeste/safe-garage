package br.com.safegarage.scheduler_service.repository;

import java.util.List;

import br.com.safegarage.scheduler_service.entity.SchedulerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<SchedulerEntity, Long> {

    List<SchedulerEntity> findAllByCustomerId(Long customerId);
}
