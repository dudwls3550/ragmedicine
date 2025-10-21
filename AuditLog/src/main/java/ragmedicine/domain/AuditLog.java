package ragmedicine.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ragmedicine.AuditLogApplication;

@Entity
@Table(name = "AuditLog_table")
@Data
//<<< DDD / Aggregate Root
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auditLogId;

    private LogType eventType;

    private Date eventTimestamp;

    private Long actorId;

    private String actorType;

    private String eventData;

    private Integer logLevel;

    private EventSource source;

    private Date createdAt;

    private Date updatedAt;

    private Date retentionExpiryAt;

    @Embedded
    private KnowledgeSyncId knowledgeSyncId;

    @Embedded
    private QuestionAnswerId questionAnswerId;

    @Embedded
    private AnswerGenerationId answerGenerationId;

    @Embedded
    private FeedbackId feedbackId;

    @Embedded
    private UserId userId;

    public static AuditLogRepository repository() {
        AuditLogRepository auditLogRepository = AuditLogApplication.applicationContext.getBean(
            AuditLogRepository.class
        );
        return auditLogRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recordAuthenticationActivity(
        UserAuthenticated userAuthenticated
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AuditLog auditLog = new AuditLog();
        repository().save(auditLog);

        LogRecorded logRecorded = new LogRecorded(auditLog);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if userAuthenticated.userId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> authenticationTokenMap = mapper.convertValue(userAuthenticated.getUserId(), Map.class);

        repository().findById(userAuthenticated.get???()).ifPresent(auditLog->{
            
            auditLog // do something
            repository().save(auditLog);

            LogRecorded logRecorded = new LogRecorded(auditLog);
            logRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recordSuccessfulSync(
        ExternalKnowledgeSynchronized externalKnowledgeSynchronized
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AuditLog auditLog = new AuditLog();
        repository().save(auditLog);

        LogRecorded logRecorded = new LogRecorded(auditLog);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(externalKnowledgeSynchronized.get???()).ifPresent(auditLog->{
            
            auditLog // do something
            repository().save(auditLog);

            LogRecorded logRecorded = new LogRecorded(auditLog);
            logRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void logAnswerView(AnswerViewed answerViewed) {
        //implement business logic here:

        /** Example 1:  new item 
        AuditLog auditLog = new AuditLog();
        repository().save(auditLog);

        LogRecorded logRecorded = new LogRecorded(auditLog);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if answerViewed.userIdanswerGenerationId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(answerViewed.getUserId(), Map.class);
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(answerViewed.getAnswerGenerationId(), Map.class);

        repository().findById(answerViewed.get???()).ifPresent(auditLog->{
            
            auditLog // do something
            repository().save(auditLog);

            LogRecorded logRecorded = new LogRecorded(auditLog);
            logRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void logUserRegistration(UserRegistered userRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        AuditLog auditLog = new AuditLog();
        repository().save(auditLog);

        LogRecorded logRecorded = new LogRecorded(auditLog);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(userRegistered.get???()).ifPresent(auditLog->{
            
            auditLog // do something
            repository().save(auditLog);

            LogRecorded logRecorded = new LogRecorded(auditLog);
            logRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recordFailedSync(
        ExternalKnowledgeSyncFailed externalKnowledgeSyncFailed
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AuditLog auditLog = new AuditLog();
        repository().save(auditLog);

        LogRecorded logRecorded = new LogRecorded(auditLog);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(externalKnowledgeSyncFailed.get???()).ifPresent(auditLog->{
            
            auditLog // do something
            repository().save(auditLog);

            LogRecorded logRecorded = new LogRecorded(auditLog);
            logRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void logFeedbackSubmission(
        FeedbackSubmitted feedbackSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AuditLog auditLog = new AuditLog();
        repository().save(auditLog);

        LogRecorded logRecorded = new LogRecorded(auditLog);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackSubmitted.userIdquestionAnswerId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getUserId(), Map.class);
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getQuestionAnswerId(), Map.class);

        repository().findById(feedbackSubmitted.get???()).ifPresent(auditLog->{
            
            auditLog // do something
            repository().save(auditLog);

            LogRecorded logRecorded = new LogRecorded(auditLog);
            logRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void logQnASubmission(QuestionSubmitted questionSubmitted) {
        //implement business logic here:

        /** Example 1:  new item 
        AuditLog auditLog = new AuditLog();
        repository().save(auditLog);

        LogRecorded logRecorded = new LogRecorded(auditLog);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if questionSubmitted.userIdanswerGenerationId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(questionSubmitted.getUserId(), Map.class);
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(questionSubmitted.getAnswerGenerationId(), Map.class);

        repository().findById(questionSubmitted.get???()).ifPresent(auditLog->{
            
            auditLog // do something
            repository().save(auditLog);

            LogRecorded logRecorded = new LogRecorded(auditLog);
            logRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void logAbnormalActivityDetection(
        AbnormalActivityDetected abnormalActivityDetected
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AuditLog auditLog = new AuditLog();
        repository().save(auditLog);

        LogRecorded logRecorded = new LogRecorded(auditLog);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if abnormalActivityDetected.auditLogIduserIdfeedbackNotificationId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> abnormalActivityMap = mapper.convertValue(abnormalActivityDetected.getAuditLogId(), Map.class);
        // Map<Long, Object> abnormalActivityMap = mapper.convertValue(abnormalActivityDetected.getUserId(), Map.class);
        // Map<Long, Object> abnormalActivityMap = mapper.convertValue(abnormalActivityDetected.getFeedbackNotificationId(), Map.class);

        repository().findById(abnormalActivityDetected.get???()).ifPresent(auditLog->{
            
            auditLog // do something
            repository().save(auditLog);

            LogRecorded logRecorded = new LogRecorded(auditLog);
            logRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void logUserSuspension(UserSuspended userSuspended) {
        //implement business logic here:

        /** Example 1:  new item 
        AuditLog auditLog = new AuditLog();
        repository().save(auditLog);

        LogRecorded logRecorded = new LogRecorded(auditLog);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(userSuspended.get???()).ifPresent(auditLog->{
            
            auditLog // do something
            repository().save(auditLog);

            LogRecorded logRecorded = new LogRecorded(auditLog);
            logRecorded.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
