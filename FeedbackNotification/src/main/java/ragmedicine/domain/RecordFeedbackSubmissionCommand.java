package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RecordFeedbackSubmissionCommand {

    private QuestionAnswerId questionAnswerId;
    private Boolean isDissatisfied;
}
