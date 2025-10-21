package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubmitFollowUpQuestionCommand {

    private Long answerGenerationId;
    private String followUpQuestionContent;
}
