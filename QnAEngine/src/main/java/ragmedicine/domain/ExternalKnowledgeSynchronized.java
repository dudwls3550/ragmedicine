package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class ExternalKnowledgeSynchronized extends AbstractEvent {

    private Long syncId;
    private Date lastSyncedAt;
    private Object syncStatus;
    private String syncData;
    private String syncLog;
}
