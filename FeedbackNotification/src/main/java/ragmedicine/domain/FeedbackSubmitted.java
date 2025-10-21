package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class FeedbackSubmitted extends AbstractEvent {

    private Long feedbackId;
    private Object questionAnswerId;
    private Long residentId;
    private Object feedbackType;
    private String feedbackContent;
    private Date createdAt;
    private Object feedbackStatus;
    private Object userId;
}
