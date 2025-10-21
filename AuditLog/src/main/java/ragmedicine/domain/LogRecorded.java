package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LogRecorded extends AbstractEvent {

    private Long auditLogId;
    private LogType eventType;
    private Date eventTimestamp;
    private Long actorId;
    private String eventData;
    private Integer logLevel;
    private EventSource source;
    private Date retentionExpiryAt;
    private QuestionAnswerId questionAnswerId;
    private FeedbackId feedbackId;
    private KnowledgeSyncId knowledgeSyncId;

    public LogRecorded(LogRetentionPolicy aggregate) {
        super(aggregate);
    }

    public LogRecorded() {
        super();
    }
}
//>>> DDD / Domain Event
