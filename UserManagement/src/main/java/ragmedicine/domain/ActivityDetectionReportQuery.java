package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ActivityDetectionReportQuery {

    private Long abnormalActivityId;
    private UserId userId;
}
