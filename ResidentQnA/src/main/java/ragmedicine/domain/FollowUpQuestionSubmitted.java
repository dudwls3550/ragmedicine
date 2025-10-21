package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class FollowUpQuestionSubmitted extends AbstractEvent {

    private Long questionAnswerId;
    private Long parentQuestionAnswerId;
    private Long residentId;
    private String followUpContent;
    private Date createdAt;

    public FollowUpQuestionSubmitted(QuestionAnswer aggregate) {
        super(aggregate);
    }

    public FollowUpQuestionSubmitted() {
        super();
    }
}
//>>> DDD / Domain Event
