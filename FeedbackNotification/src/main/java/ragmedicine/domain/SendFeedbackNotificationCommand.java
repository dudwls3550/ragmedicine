package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SendFeedbackNotificationCommand {

    private Long feedbackStatisticsId;
    private Long adminId;
    private Integer eventLevel;
    private FeedbackId feedbackId;
    private UserId userId;
}
