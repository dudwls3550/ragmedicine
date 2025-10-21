package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class EvidenceRetrieved extends AbstractEvent {

    private Long sourceEvidenceId;
    private Long answerGenerationId;
    private KnowledgeSyncId knowledgeSyncId;
    private String sourceTitle;
    private String sourceUrl;
    private EvidenceType sourceType;
    private Date retrievedAt;

    public EvidenceRetrieved(SourceEvidence aggregate) {
        super(aggregate);
    }

    public EvidenceRetrieved() {
        super();
    }
}
//>>> DDD / Domain Event
