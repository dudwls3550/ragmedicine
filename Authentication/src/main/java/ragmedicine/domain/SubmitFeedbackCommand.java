package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubmitFeedbackCommand {

    private Long answerGenerationId;
    private String feedbackType;
    private String feedbackContent;
}
