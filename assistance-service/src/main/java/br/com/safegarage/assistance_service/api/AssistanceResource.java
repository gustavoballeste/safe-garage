package br.com.safegarage.assistance_service.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Customers")
@RestController
@RequestMapping("/assistance")
public class AssistanceResource {

    @GetMapping
    @ApiOperation("Get assistances")
    public String getAssistances() {
        return "Listar serviços";
    }
}
