package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AnswerGenerated extends AbstractEvent {

    private Long answerGenerationId;
    private String questionContent;
    private String answerContent;
    private Double reliabilityScore;
    private Boolean personalInfoFiltered;
    private List<String> sourceEvidenceIds;
    private Date createdAt;
    private AnswerGenerationStatus status;

    public AnswerGenerated(AnswerGeneration aggregate) {
        super(aggregate);
    }

    public AnswerGenerated() {
        super();
    }
}
//>>> DDD / Domain Event
