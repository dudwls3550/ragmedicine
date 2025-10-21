package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FeedbackNotificationTriggered extends AbstractEvent {

    private Long notificationId;
    private Long feedbackStatisticsId;
    private Long adminId;
    private Integer eventLevel;
    private Date triggeredAt;
    private FeedbackId feedbackId;

    public FeedbackNotificationTriggered(FeedbackNotification aggregate) {
        super(aggregate);
    }

    public FeedbackNotificationTriggered() {
        super();
    }
}
//>>> DDD / Domain Event
