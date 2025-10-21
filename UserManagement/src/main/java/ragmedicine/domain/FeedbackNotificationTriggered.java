package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class FeedbackNotificationTriggered extends AbstractEvent {

    private Long notificationId;
    private Long feedbackStatisticsId;
    private Long adminId;
    private Integer eventLevel;
    private Date triggeredAt;
    private Object feedbackId;
}
