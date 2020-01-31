package br.com.safegarage.customer_bff.domain.model;

import java.time.LocalDate;

import br.com.safegarage.customer_bff.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Long id;

    private String name;

    private LocalDate bornDate;

    private String street;

    private String number;

    private String zipCode;

    private String city;

    private String state;

    public static Customer customerEntityToCustomer (final CustomerEntity customerEntity) {
        return Customer.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .bornDate(customerEntity.getBornDate())
                .street(customerEntity.getStreet())
                .city(customerEntity.getCity())
                .state(customerEntity.getState())
                .zipCode(customerEntity.getZipCode())
                .number(customerEntity.getNumber())
                .build();
    }

    public CustomerEntity toCustomerEntity() {
        return CustomerEntity.builder()
                .id(this.id)
                .name(this.name)
                .bornDate(this.bornDate)
                .street(this.street)
                .city(this.city)
                .state(this.state)
                .zipCode(this.zipCode)
                .number(this.number)
                .build();
    }

}
