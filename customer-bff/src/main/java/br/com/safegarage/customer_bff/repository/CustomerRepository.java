package br.com.safegarage.customer_bff.repository;

import br.com.safegarage.customer_bff.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
