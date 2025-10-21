package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubmitFeedbackCommand {

    private QuestionAnswerId questionAnswerId;
    private Long residentId;
    private FeedbackType feedbackType;
    private String feedbackContent;
}
