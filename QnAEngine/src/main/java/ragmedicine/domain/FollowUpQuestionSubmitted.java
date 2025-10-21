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

    private Long previousAnswerId;
    private String followUpQuestionContent;
    private Long newAnswerGenerationId;

    public FollowUpQuestionSubmitted(AnswerGeneration aggregate) {
        super(aggregate);
    }

    public FollowUpQuestionSubmitted() {
        super();
    }
}
//>>> DDD / Domain Event
