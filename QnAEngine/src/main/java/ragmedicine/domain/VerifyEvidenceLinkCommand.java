package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class VerifyEvidenceLinkCommand {

    private Long sourceEvidenceId;
    private Date verificationTimestamp;
}
