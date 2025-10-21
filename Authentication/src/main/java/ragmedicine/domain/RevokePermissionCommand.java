package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RevokePermissionCommand {

    private Long authorizationId;
    private String revokedBy;
}
