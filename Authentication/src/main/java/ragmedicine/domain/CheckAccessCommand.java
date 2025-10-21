package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CheckAccessCommand {

    private Long userId;
    private String resourceIdentifier;
    private AuthorizationLevel requiredLevel;
}
