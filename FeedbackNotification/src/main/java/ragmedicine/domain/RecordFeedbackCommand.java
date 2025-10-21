package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RecordFeedbackCommand {

    private Long feedbackStatisticsId;
    private QuestionAnswerId questionAnswerId;
    private FeedbackSatisfactionLevel satisfactionLevel;
}
