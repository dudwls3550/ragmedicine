package ragmedicine.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ragmedicine.UserManagementApplication;

@Entity
@Table(name = "AbnormalActivity_table")
@Data
//<<< DDD / Aggregate Root
public class AbnormalActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long abnormalActivityId;

    private Date detectedAt;

    private AbnormalActivityType activityType;

    private String description;

    private String detectedBy;

    private String detectionResult;

    private AbnormalActivityStatus status;

    private Date createdAt;

    private Date updatedAt;

    @Embedded
    private UserId userId;

    @Embedded
    private AuditLogId auditLogId;

    @Embedded
    private FeedbackNotificationId feedbackNotificationId;

    public static AbnormalActivityRepository repository() {
        AbnormalActivityRepository abnormalActivityRepository = UserManagementApplication.applicationContext.getBean(
            AbnormalActivityRepository.class
        );
        return abnormalActivityRepository;
    }

    //<<< Clean Arch / Port Method
    public static void analyzeUserActivityOnQuestion(
        QuestionSubmitted questionSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AbnormalActivity abnormalActivity = new AbnormalActivity();
        repository().save(abnormalActivity);

        AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
        abnormalActivityDetected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if questionSubmitted.userIdanswerGenerationId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(questionSubmitted.getUserId(), Map.class);
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(questionSubmitted.getAnswerGenerationId(), Map.class);

        repository().findById(questionSubmitted.get???()).ifPresent(abnormalActivity->{
            
            abnormalActivity // do something
            repository().save(abnormalActivity);

            AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
            abnormalActivityDetected.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void analyzeUserActivityOnFeedback(
        FeedbackSubmitted feedbackSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AbnormalActivity abnormalActivity = new AbnormalActivity();
        repository().save(abnormalActivity);

        AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
        abnormalActivityDetected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackSubmitted.userIdquestionAnswerId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getUserId(), Map.class);
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getQuestionAnswerId(), Map.class);

        repository().findById(feedbackSubmitted.get???()).ifPresent(abnormalActivity->{
            
            abnormalActivity // do something
            repository().save(abnormalActivity);

            AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
            abnormalActivityDetected.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyAdministratorOnTrigger(
        FeedbackNotificationTriggered feedbackNotificationTriggered
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AbnormalActivity abnormalActivity = new AbnormalActivity();
        repository().save(abnormalActivity);

        AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
        abnormalActivityDetected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackNotificationTriggered.feedbackIduserId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackNotificationMap = mapper.convertValue(feedbackNotificationTriggered.getFeedbackId(), Map.class);
        // Map<Long, Object> feedbackNotificationMap = mapper.convertValue(feedbackNotificationTriggered.getUserId(), Map.class);

        repository().findById(feedbackNotificationTriggered.get???()).ifPresent(abnormalActivity->{
            
            abnormalActivity // do something
            repository().save(abnormalActivity);

            AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
            abnormalActivityDetected.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void triggerAbnormalDetectionOnNegativeFeedback(
        FeedbackNotificationTriggered feedbackNotificationTriggered
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AbnormalActivity abnormalActivity = new AbnormalActivity();
        repository().save(abnormalActivity);

        AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
        abnormalActivityDetected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackNotificationTriggered.feedbackIduserId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackNotificationMap = mapper.convertValue(feedbackNotificationTriggered.getFeedbackId(), Map.class);
        // Map<Long, Object> feedbackNotificationMap = mapper.convertValue(feedbackNotificationTriggered.getUserId(), Map.class);

        repository().findById(feedbackNotificationTriggered.get???()).ifPresent(abnormalActivity->{
            
            abnormalActivity // do something
            repository().save(abnormalActivity);

            AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
            abnormalActivityDetected.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void monitorUserActivity(
        QuestionSubmitted questionSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        AbnormalActivity abnormalActivity = new AbnormalActivity();
        repository().save(abnormalActivity);

        AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
        abnormalActivityDetected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if questionSubmitted.userIdanswerGenerationId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(questionSubmitted.getUserId(), Map.class);
        // Map<Long, Object> questionAnswerMap = mapper.convertValue(questionSubmitted.getAnswerGenerationId(), Map.class);

        repository().findById(questionSubmitted.get???()).ifPresent(abnormalActivity->{
            
            abnormalActivity // do something
            repository().save(abnormalActivity);

            AbnormalActivityDetected abnormalActivityDetected = new AbnormalActivityDetected(abnormalActivity);
            abnormalActivityDetected.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
