package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RecordSourceEvidenceCommand {

    private Long answerGenerationId;
    private EvidenceType sourceType;
    private String sourceTitle;
    private String sourceUrl;
    private KnowledgeSyncId knowledgeSyncId;
}
