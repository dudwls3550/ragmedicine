package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AnswerViewed extends AbstractEvent {

    private Long questionAnswerId;
    private Long residentId;
    private AnswerStatus answerStatus;

    public AnswerViewed(QuestionAnswer aggregate) {
        super(aggregate);
    }

    public AnswerViewed() {
        super();
    }
}
//>>> DDD / Domain Event
