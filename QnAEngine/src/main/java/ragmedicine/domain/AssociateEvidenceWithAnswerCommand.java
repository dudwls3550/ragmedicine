package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AssociateEvidenceWithAnswerCommand {

    private Long sourceEvidenceId;
    private Long answerGenerationId;
    private String sourceTitle;
    private String sourceUrl;
    private EvidenceType sourceType;
    private Date retrievedAt;
}
