package br.com.safegarage.customer_bff.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.safegarage.customer_bff.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "customer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "company_id")
    private Long companyId;

    private String assistanceName;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "assistance_description")
    private String assistanceDescription;

    private Status status;

}
