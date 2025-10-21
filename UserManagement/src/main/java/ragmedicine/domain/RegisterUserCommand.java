package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RegisterUserCommand {

    private UserProfile profile;
    private MedicalInstitutionVerification verification;
    private String encryptedPassword;
}
