package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateSyncConfigurationCommand {

    private Long syncId;
    private String syncCycle;
    private String externalDbStatus;
}
