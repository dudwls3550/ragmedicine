package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateUserProfileCommand {

    private Long userId;
    private UserProfile profile;
}
