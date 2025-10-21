package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ExternalKnowledgeSynchronized extends AbstractEvent {

    private Long syncId;
    private Date lastSyncedAt;
    private SyncStatus syncStatus;
    private String syncData;
    private String syncLog;

    public ExternalKnowledgeSynchronized(KnowledgeSync aggregate) {
        super(aggregate);
    }

    public ExternalKnowledgeSynchronized() {
        super();
    }
}
//>>> DDD / Domain Event
