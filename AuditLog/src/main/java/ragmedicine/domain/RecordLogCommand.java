package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RecordLogCommand {

    private LogType eventType;
    private Long actorId;
    private String eventData;
    private Integer logLevel;
    private EventSource source;
    private QuestionAnswerId questionAnswerId;
    private FeedbackId feedbackId;
    private KnowledgeSyncId knowledgeSyncId;
}
