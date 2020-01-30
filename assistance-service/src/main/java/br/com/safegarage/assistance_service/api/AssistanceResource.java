package br.com.safegarage.assistance_service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assistance")
public class AssistanceResource {

    @GetMapping
    public String getAssistances() {
        return "Listar serviços";
    }
}
