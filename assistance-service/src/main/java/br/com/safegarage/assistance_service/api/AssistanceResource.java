package br.com.safegarage.assistance_service.api;

import java.util.List;

import br.com.safegarage.assistance_service.model.Assistance;
import br.com.safegarage.assistance_service.service.AssistanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={ "Assistance Api"})
@RestController
@RequestMapping("/assistance")
public class AssistanceResource {

    @Autowired
    private AssistanceService assistanceService;

    @ApiOperation("Get assistances")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Assistance>> getAssistances(@RequestParam final String category) {
        return ResponseEntity.ok(assistanceService.getAllByCategory(category));
    }

}
