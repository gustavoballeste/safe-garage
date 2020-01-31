package br.com.safegarage.customer_bff.repository;

import br.com.safegarage.customer_bff.entity.SchedulerEntity;

public interface SchedulerRepository extends JpaRepository<SchedulerEntity, Long> {

    List<SchedulerEntity> findAllByCustomerId(Long customerId);
}
