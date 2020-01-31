package br.com.safegarage.customer_bff.api;

import java.util.List;
import java.util.Optional;

import br.com.safegarage.customer_bff.domain.model.Customer;
import br.com.safegarage.customer_bff.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags={ "Customer Api"})
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("Create new customer")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> create(@RequestBody final Customer customer) {
        return ResponseEntity.ok().body(customerService.save(customer));
    }

    @ApiOperation("Retrieve an existing customer")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") final Long id) {
        final Optional<Customer> customer = customerService.getById(id);
        return (customer.isPresent()) ?
                ResponseEntity.ok().body(customer.get()) :
                ResponseEntity.notFound().build();
    }

    @ApiOperation("Retrieve all customers")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAll() {
        final List<Customer> customers = customerService.getAll();
        return (customers.isEmpty()) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok().body(customers);
    }

    @ApiOperation("Update an existing customer and update the address")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update")
    public ResponseEntity validate(@RequestBody final Customer customer) {
        final Optional<Customer> response = customerService.update(customer);
        return (response.isPresent()) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
    
    @ApiOperation("Delete an existing customer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") final Long id) {
        final Optional<Customer> optionalCustomer = customerService.getById(id);
        if (optionalCustomer.isPresent()) {
            customerService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
