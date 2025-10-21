package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AbnormalActivityDetected extends AbstractEvent {

    private Long abnormalActivityId;
    private UserId userId;
    private Date detectedAt;
    private AbnormalActivityType activityType;
    private String description;
    private String detectionResult;
    private AbnormalActivityStatus status;

    public AbnormalActivityDetected(AbnormalActivity aggregate) {
        super(aggregate);
    }

    public AbnormalActivityDetected() {
        super();
    }
}
//>>> DDD / Domain Event
