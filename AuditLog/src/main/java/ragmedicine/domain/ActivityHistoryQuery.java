package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ActivityHistoryQuery {

    private Long userId;
    private Date startDate;
    private Date endDate;
    private LogType eventType;
}
