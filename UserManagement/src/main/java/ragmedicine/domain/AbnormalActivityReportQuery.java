package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AbnormalActivityReportQuery {

    private UserId userId;
    private AbnormalActivityStatus status;
    private Date startDate;
}
