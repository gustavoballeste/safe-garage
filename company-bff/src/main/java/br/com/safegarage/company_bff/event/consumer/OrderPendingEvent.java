package br.com.safegarage.company_bff.event.consumer;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPendingEvent implements Serializable {

    private static final long serialVersionUID = -7554010751864838979L;

    private Long id;
    private Long customerId;
    private Long companyId;
    private String assistanceName;
    private String assistanceDescription;
    private LocalDateTime dateTime;
    private String status;

}
