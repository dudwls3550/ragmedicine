package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class UserActivityHistoryQuery {

    private Long userId;
    private Date startDate;
    private Date endDate;
}
