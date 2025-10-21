package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ExternalKnowledgeSyncFailed extends AbstractEvent {

    private Long syncId;
    private String failureReason;
    private SyncStatus syncStatus;
    private Date updatedAt;

    public ExternalKnowledgeSyncFailed(KnowledgeSync aggregate) {
        super(aggregate);
    }

    public ExternalKnowledgeSyncFailed() {
        super();
    }
}
//>>> DDD / Domain Event
