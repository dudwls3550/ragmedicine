package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class QuestionSubmitted extends AbstractEvent {

    private Long questionAnswerId;
    private Long residentId;
    private String questionContent;
    private Date createdAt;
    private QuestionStatus questionStatus;

    public QuestionSubmitted(QuestionAnswer aggregate) {
        super(aggregate);
    }

    public QuestionSubmitted() {
        super();
    }
}
//>>> DDD / Domain Event
