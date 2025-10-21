package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SyncFailureAlertSent extends AbstractEvent {

    private Long alertId;
    private Long syncId;
    private String failureReason;
    private Date notifiedAt;
    private AlertStatus alertStatus;

    public SyncFailureAlertSent(SyncFailureAlert aggregate) {
        super(aggregate);
    }

    public SyncFailureAlertSent() {
        super();
    }
}
//>>> DDD / Domain Event
