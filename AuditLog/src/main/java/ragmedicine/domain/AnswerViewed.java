package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class AnswerViewed extends AbstractEvent {

    private Long questionAnswerId;
    private Long residentId;
    private Object answerStatus;
}
