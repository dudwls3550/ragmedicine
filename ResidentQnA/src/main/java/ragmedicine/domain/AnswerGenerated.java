package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class AnswerGenerated extends AbstractEvent {

    private Long answerGenerationId;
    private String questionContent;
    private String answerContent;
    private Double reliabilityScore;
    private Boolean personalInfoFiltered;
    private Object sourceEvidenceIds;
    private Date createdAt;
    private Object status;
}
