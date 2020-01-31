package br.com.safegarage.customer_bff.domain.model;

import java.time.LocalDateTime;

import br.com.safegarage.customer_bff.domain.Status;
import br.com.safegarage.customer_bff.entity.SchedulerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scheduler {

    private Long customerId;

    private Long companyId;

    private String assistanceName;

    private String assistanceDescription;

    private LocalDateTime dateTime;

    private Status status;

    public static Scheduler customerEntityToCustomer(final SchedulerEntity assistanceSchedulerEntity) {
        return Scheduler.builder()
                .customerId(assistanceSchedulerEntity.getCustomerId())
                .companyId(assistanceSchedulerEntity.getCompanyId())
                .assistanceName(assistanceSchedulerEntity.getAssistanceName())
                .assistanceDescription(assistanceSchedulerEntity.getAssistanceDescription())
                .dateTime(assistanceSchedulerEntity.getDateTime())
                .status(assistanceSchedulerEntity.getStatus())
                .build();
    }

    public SchedulerEntity toSchedulerEntity () {
        return SchedulerEntity.builder()
                .customerId(this.customerId)
                .companyId(this.companyId)
                .assistanceName(this.assistanceName)
                .assistanceDescription(this.assistanceDescription)
                .dateTime(this.dateTime)
                .status(this.status)
                .build();
    }

    public boolean isCanceled() {
        return Status.CANCELED.equals(this.status);
    }
}
