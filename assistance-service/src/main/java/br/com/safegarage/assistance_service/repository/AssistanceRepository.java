package br.com.safegarage.assistance_service.repository;

import java.util.List;

import br.com.safegarage.assistance_service.model.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssistanceRepository extends JpaRepository<Assistance, Long> {

    List<Assistance> findAllByCategory(String category);
}
