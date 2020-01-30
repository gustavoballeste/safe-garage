package br.com.safegarage.assistance_service.service;

import java.util.List;

import br.com.safegarage.assistance_service.model.Assistance;
import br.com.safegarage.assistance_service.repository.AssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssistanceService {

    @Autowired
    private AssistanceRepository assistanceRepository;

    public List<Assistance> getAllByCategory (final String category) {
        return assistanceRepository.findAllByCategory(category);
    }

}
