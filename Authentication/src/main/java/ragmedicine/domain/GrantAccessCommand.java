package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class GrantAccessCommand {

    private Long userId;
    private AuthorizationLevel level;
    private String role;
    private String permissionType;
}
