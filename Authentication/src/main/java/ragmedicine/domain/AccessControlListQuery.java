package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AccessControlListQuery {

    private AuthorizationStatus status;
    private AuthorizationLevel role;
}
