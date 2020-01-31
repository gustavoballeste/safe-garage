package br.com.safegarage.scheduler_service.api;

import br.com.safegarage.scheduler_service.domain.Status;
import br.com.safegarage.scheduler_service.domain.model.Scheduler;
import br.com.safegarage.scheduler_service.service.SchedulerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = { "Scheduler Api" })
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    private SchedulerService schedulerService;

    @ApiOperation("Create new scheduler")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Scheduler> create (@RequestBody final Scheduler scheduler) {
        return ResponseEntity.ok().body(schedulerService.create(scheduler));
    }

    @ApiOperation("Update the scheduler status")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/{id}")
    public ResponseEntity updateStatus (@PathVariable("id") final Long id,
            @ApiParam("The new status. Can be 'confirmed', 'canceled' or 'pending'") @RequestParam("status") final String status) {
        final String newStatus = status.toUpperCase();
        if (!EnumUtils.isValidEnum(Status.class, newStatus)) {
            return ResponseEntity.badRequest().build();
        }
        final boolean isChanged = schedulerService.updateStatus(id, newStatus);
        if (isChanged) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
