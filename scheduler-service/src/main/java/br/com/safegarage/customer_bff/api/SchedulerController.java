package br.com.safegarage.customer_bff.api;

import java.util.List;

import br.com.safegarage.customer_bff.domain.model.Scheduler;
import br.com.safegarage.customer_bff.service.SchedulerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={ "Scheduler Api"})
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @ApiOperation("Create new scheduler")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Scheduler> create(@RequestBody final Scheduler scheduler) {
        return ResponseEntity.ok().body(schedulerService.create(scheduler));
    }

    @ApiOperation("Retrieve all schedulers by customer")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Scheduler>> getAllByCustomerId(@RequestParam final Long customerId) {
        final List<Scheduler> schedulers = schedulerService.getAllByCustomer(customerId);
        return (schedulers.isEmpty()) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok().body(schedulers);
    }

    @ApiOperation("Cancel an existing scheduler")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Scheduler> cancel(@PathVariable("id") final Long id) {
        final boolean isCanceled = schedulerService.cancel(id);
        if (isCanceled) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation("Confirm an existing scheduler")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Scheduler> confirm(@PathVariable("id") final Long id) {
        final boolean isConfirmed = schedulerService.confirm(id);
        if (isConfirmed) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
