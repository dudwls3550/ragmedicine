package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AuthenticateUserCommand {

    private Long userId;
    private String loginCredentials;
}
