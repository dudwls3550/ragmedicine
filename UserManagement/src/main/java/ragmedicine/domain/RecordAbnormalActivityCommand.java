package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RecordAbnormalActivityCommand {

    private Long abnormalActivityId;
    private UserId userId;
    private AbnormalActivityType activityType;
    private String description;
    private String detectionResult;
}
