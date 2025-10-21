package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateRetentionPolicyCommand {

    private Long logRetentionPolicyId;
    private String policyName;
    private Integer retentionPeriodYears;
    private Boolean isActive;
}
