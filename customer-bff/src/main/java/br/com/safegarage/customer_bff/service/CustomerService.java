package br.com.safegarage.customer_bff.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.safegarage.customer_bff.entity.CustomerEntity;
import br.com.safegarage.customer_bff.domain.model.Customer;
import br.com.safegarage.customer_bff.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(final Customer customer) {
        final CustomerEntity savedCustomer = customerRepository.save(customer.toCustomerEntity());
        return Customer.customerEntityToCustomer(savedCustomer);
    }

    public Optional<Customer> getById(final Long id) {
        return customerRepository.findById(id)
                .map(Customer::customerEntityToCustomer);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll()
                .stream()
                .map(Customer::customerEntityToCustomer)
                .collect(Collectors.toList());
    }

    public void delete(final Long id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> update (final Customer customerRequest){
        final Optional<Customer> optionalCustomer = getById(customerRequest.getId());
        if (optionalCustomer.isPresent()) {
            final Customer customer = optionalCustomer.get();
            customer.setBornDate(customerRequest.getBornDate());
            customer.setName(customerRequest.getName());
            customer.setStreet(customerRequest.getStreet());
            customer.setCity(customerRequest.getCity());
            customer.setState(customerRequest.getState());
            customer.setNumber(customerRequest.getNumber());
            customer.setZipCode(customerRequest.getZipCode());
            final CustomerEntity savedCustomer = customerRepository.save(customer.toCustomerEntity());
            return Optional.of(Customer.customerEntityToCustomer(savedCustomer));
        } else {
            return Optional.empty();
        }
    }
}
