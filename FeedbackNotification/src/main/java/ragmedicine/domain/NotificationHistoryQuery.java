package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class NotificationHistoryQuery {

    private Long adminId;
    private NotificationStatus notificationStatus;
}
