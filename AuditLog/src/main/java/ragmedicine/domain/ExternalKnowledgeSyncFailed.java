package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class ExternalKnowledgeSyncFailed extends AbstractEvent {

    private Long syncId;
    private String failureReason;
    private Object syncStatus;
    private Date updatedAt;
}
