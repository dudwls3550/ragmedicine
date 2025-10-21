package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SuspendUserCommand {

    private Long userId;
    private String suspendedReason;
}
