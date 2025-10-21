package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReviewAbnormalActivityCommand {

    private Long abnormalActivityId;
    private String reviewNotes;
    private AbnormalActivityStatus newStatus;
    private String actionTaken;
}
