package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class UserListQuery {

    private UserStatus status;
    private UserRole role;
}
