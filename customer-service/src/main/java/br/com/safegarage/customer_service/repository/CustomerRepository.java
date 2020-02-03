package br.com.safegarage.customer_service.repository;

import br.com.safegarage.customer_service.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
