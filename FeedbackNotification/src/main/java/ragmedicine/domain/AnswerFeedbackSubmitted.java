package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class AnswerFeedbackSubmitted extends AbstractEvent {

    private Long answerGenerationId;
    private String feedbackType;
    private String feedbackContent;
}
