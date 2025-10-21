package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FeedbackSubmissionRecorded extends AbstractEvent {

    private Long feedbackStatisticsId;
    private QuestionAnswerId questionAnswerId;
    private Boolean isDissatisfied;

    public FeedbackSubmissionRecorded(
        FeedbackNotificationStatistics aggregate
    ) {
        super(aggregate);
    }

    public FeedbackSubmissionRecorded() {
        super();
    }
}
//>>> DDD / Domain Event
