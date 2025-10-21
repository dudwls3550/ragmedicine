package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class EvidenceAssociated extends AbstractEvent {

    private Long sourceEvidenceId;
    private Long answerGenerationId;
    private String sourceTitle;

    public EvidenceAssociated(SourceEvidence aggregate) {
        super(aggregate);
    }

    public EvidenceAssociated() {
        super();
    }
}
//>>> DDD / Domain Event
