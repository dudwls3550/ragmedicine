package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AnswerFeedbackSubmitted extends AbstractEvent {

    private Long answerGenerationId;
    private String feedbackType;
    private String feedbackContent;

    public AnswerFeedbackSubmitted(AnswerGeneration aggregate) {
        super(aggregate);
    }

    public AnswerFeedbackSubmitted() {
        super();
    }
}
//>>> DDD / Domain Event
