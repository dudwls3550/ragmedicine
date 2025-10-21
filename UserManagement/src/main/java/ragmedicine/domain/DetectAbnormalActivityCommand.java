package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DetectAbnormalActivityCommand {

    private UserId userId;
    private AbnormalActivityType activityType;
    private String description;
    private Date detectedAt;
}
