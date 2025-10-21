package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SourceEvidenceRecorded extends AbstractEvent {

    private Long sourceEvidenceId;
    private Long answerGenerationId;
    private EvidenceType sourceType;
    private String sourceTitle;
    private String sourceUrl;
    private Date retrievedAt;
    private KnowledgeSyncId knowledgeSyncId;

    public SourceEvidenceRecorded(SourceEvidence aggregate) {
        super(aggregate);
    }

    public SourceEvidenceRecorded() {
        super();
    }
}
//>>> DDD / Domain Event
