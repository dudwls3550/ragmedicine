package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AcknowledgeSyncFailureCommand {

    private Long alertId;
    private String acknowledgedBy;
}
