package ragmedicine.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ragmedicine.QnAEngineApplication;

@Entity
@Table(name = "AnswerGeneration_table")
@Data
//<<< DDD / Aggregate Root
public class AnswerGeneration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerGenerationId;

    private String questionContent;

    private String answerContent;

    private Date createdAt;

    private Double reliabilityScore;

    private Boolean personalInfoFiltered;

    private AnswerGenerationStatus status;

    @ElementCollection
    private List<String> sourceEvidenceIds;

    @Embedded
    private SourceEvidenceId sourceEvidenceId;

    @Embedded
    private QuestionAnswerId questionAnswerId;

    @Embedded
    private KnowledgeSyncId knowledgeSyncId;

    public static AnswerGenerationRepository repository() {
        AnswerGenerationRepository answerGenerationRepository = QnAEngineApplication.applicationContext.getBean(
            AnswerGenerationRepository.class
        );
        return answerGenerationRepository;
    }

    //<<< Clean Arch / Port Method
    public void submitFeedback(SubmitFeedbackCommand submitFeedbackCommand) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
