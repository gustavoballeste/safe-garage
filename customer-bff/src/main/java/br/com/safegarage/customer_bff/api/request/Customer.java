package br.com.safegarage.customer_bff.api.request;

import java.time.LocalDate;

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

}
