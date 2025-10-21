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
@Table(name = "SourceEvidence_table")
@Data
//<<< DDD / Aggregate Root
public class SourceEvidence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sourceEvidenceId;

    private Long answerGenerationId;

    private EvidenceType sourceType;

    private String sourceTitle;

    private String sourceUrl;

    private Date retrievedAt;

    @Embedded
    private KnowledgeSyncId knowledgeSyncId;

    public static SourceEvidenceRepository repository() {
        SourceEvidenceRepository sourceEvidenceRepository = QnAEngineApplication.applicationContext.getBean(
            SourceEvidenceRepository.class
        );
        return sourceEvidenceRepository;
    }

    //<<< Clean Arch / Port Method
    public void retrieveEvidence(
        RetrieveEvidenceCommand retrieveEvidenceCommand
    ) {
        //implement business logic here:

        EvidenceRetrieved evidenceRetrieved = new EvidenceRetrieved(this);
        evidenceRetrieved.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void updateKnowledgeIndexAfterSync(
        ExternalKnowledgeSynchronized externalKnowledgeSynchronized
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        SourceEvidence sourceEvidence = new SourceEvidence();
        repository().save(sourceEvidence);

        EvidenceAssociated evidenceAssociated = new EvidenceAssociated(sourceEvidence);
        evidenceAssociated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(externalKnowledgeSynchronized.get???()).ifPresent(sourceEvidence->{
            
            sourceEvidence // do something
            repository().save(sourceEvidence);

            EvidenceAssociated evidenceAssociated = new EvidenceAssociated(sourceEvidence);
            evidenceAssociated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void initiateEvidenceRetrieval(
        QuestionSubmitted questionSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        SourceEvidence sourceEvidence = new SourceEvidence();
        repository().save(sourceEvidence);

        EvidenceRetrieved evidenceRetrieved = new EvidenceRetrieved(sourceEvidence);
        evidenceRetrieved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if questionSubmitted.userIdanswerGenerationId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(questionSubmitted.getUserId(), Map.class);
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(questionSubmitted.getAnswerGenerationId(), Map.class);

        repository().findById(questionSubmitted.get???()).ifPresent(sourceEvidence->{
            
            sourceEvidence // do something
            repository().save(sourceEvidence);

            EvidenceRetrieved evidenceRetrieved = new EvidenceRetrieved(sourceEvidence);
            evidenceRetrieved.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void followUpQuestionToEvidenceRetrieval(
        FollowUpQuestionSubmitted followUpQuestionSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        SourceEvidence sourceEvidence = new SourceEvidence();
        repository().save(sourceEvidence);

        EvidenceRetrieved evidenceRetrieved = new EvidenceRetrieved(sourceEvidence);
        evidenceRetrieved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if followUpQuestionSubmitted.userIdanswerGenerationId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(followUpQuestionSubmitted.getUserId(), Map.class);
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(followUpQuestionSubmitted.getAnswerGenerationId(), Map.class);

        repository().findById(followUpQuestionSubmitted.get???()).ifPresent(sourceEvidence->{
            
            sourceEvidence // do something
            repository().save(sourceEvidence);

            EvidenceRetrieved evidenceRetrieved = new EvidenceRetrieved(sourceEvidence);
            evidenceRetrieved.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void knowledgeSyncUpdatesSourceEvidence(
        ExternalKnowledgeSynchronized externalKnowledgeSynchronized
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        SourceEvidence sourceEvidence = new SourceEvidence();
        repository().save(sourceEvidence);

        SourceEvidenceRecorded sourceEvidenceRecorded = new SourceEvidenceRecorded(sourceEvidence);
        sourceEvidenceRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(externalKnowledgeSynchronized.get???()).ifPresent(sourceEvidence->{
            
            sourceEvidence // do something
            repository().save(sourceEvidence);

            SourceEvidenceRecorded sourceEvidenceRecorded = new SourceEvidenceRecorded(sourceEvidence);
            sourceEvidenceRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void answerGenerationSourceRecording(
        AnswerGenerated answerGenerated
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        SourceEvidence sourceEvidence = new SourceEvidence();
        repository().save(sourceEvidence);

        SourceEvidenceRecorded sourceEvidenceRecorded = new SourceEvidenceRecorded(sourceEvidence);
        sourceEvidenceRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if answerGenerated.sourceEvidenceIdknowledgeSyncId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> answerGenerationMap = mapper.convertValue(answerGenerated.getSourceEvidenceId(), Map.class);
        // Map<Long, Object> answerGenerationMap = mapper.convertValue(answerGenerated.getKnowledgeSyncId(), Map.class);

        repository().findById(answerGenerated.get???()).ifPresent(sourceEvidence->{
            
            sourceEvidence // do something
            repository().save(sourceEvidence);

            SourceEvidenceRecorded sourceEvidenceRecorded = new SourceEvidenceRecorded(sourceEvidence);
            sourceEvidenceRecorded.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
