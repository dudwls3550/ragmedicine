package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AcknowledgeNotificationCommand {

    private Long notificationId;
    private Long adminId;
}
