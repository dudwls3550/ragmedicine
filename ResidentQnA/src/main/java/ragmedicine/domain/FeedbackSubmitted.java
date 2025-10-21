package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FeedbackSubmitted extends AbstractEvent {

    private Long feedbackId;
    private QuestionAnswerId questionAnswerId;
    private Long residentId;
    private FeedbackType feedbackType;
    private String feedbackContent;
    private Date createdAt;
    private FeedbackStatus feedbackStatus;
    private Boolean adminNotificationSent;

    public FeedbackSubmitted(Feedback aggregate) {
        super(aggregate);
    }

    public FeedbackSubmitted() {
        super();
    }
}
//>>> DDD / Domain Event
