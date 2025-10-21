package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RetrieveEvidenceCommand {

    private Long answerGenerationId;
    private String questionContent;
    private KnowledgeSyncId knowledgeSyncId;
}
