package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SendSyncFailureAlertCommand {

    private Long syncId;
    private String failureReason;
}
