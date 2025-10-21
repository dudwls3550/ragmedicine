package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ActivityLogSummaryQuery {

    private Long actorId;
    private LogType eventType;
}
