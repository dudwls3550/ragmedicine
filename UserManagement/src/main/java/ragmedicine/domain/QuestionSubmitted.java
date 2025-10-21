package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class QuestionSubmitted extends AbstractEvent {

    private Long questionAnswerId;
    private Long residentId;
    private String questionContent;
    private Date createdAt;
    private Object questionStatus;
}
