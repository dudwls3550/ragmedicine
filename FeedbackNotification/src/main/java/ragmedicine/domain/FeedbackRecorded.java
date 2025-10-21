package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FeedbackRecorded extends AbstractEvent {

    private Long feedbackStatisticsId;
    private QuestionAnswerId questionAnswerId;
    private FeedbackSatisfactionLevel satisfactionLevel;
    private Date recordedAt;

    public FeedbackRecorded(FeedbackNotificationStatistics aggregate) {
        super(aggregate);
    }

    public FeedbackRecorded() {
        super();
    }
}
//>>> DDD / Domain Event
