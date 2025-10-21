package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PermissionListQuery {

    private AuthorizationStatus status;
    private AuthorizationLevel level;
}
