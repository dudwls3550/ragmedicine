package ragmedicine.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ragmedicine.FeedbackNotificationApplication;

@Entity
@Table(name = "FeedbackNotification_table")
@Data
//<<< DDD / Aggregate Root
public class FeedbackNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long notificationId;

    private Long feedbackStatisticsId;

    private Long adminId;

    private Integer eventLevel;

    private NotificationStatus notificationStatus;

    private Date triggeredAt;

    private Date createdAt;

    @Embedded
    private UserId userId;

    @Embedded
    private FeedbackId feedbackId;

    public static FeedbackNotificationRepository repository() {
        FeedbackNotificationRepository feedbackNotificationRepository = FeedbackNotificationApplication.applicationContext.getBean(
            FeedbackNotificationRepository.class
        );
        return feedbackNotificationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void checkThresholdAndTriggerNotification(
        FeedbackSubmissionRecorded feedbackSubmissionRecorded
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        FeedbackNotification feedbackNotification = new FeedbackNotification();
        repository().save(feedbackNotification);

        FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
        feedbackNotificationTriggered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackSubmissionRecorded.questionAnswerId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackNotificationStatisticsMap = mapper.convertValue(feedbackSubmissionRecorded.getQuestionAnswerId(), Map.class);

        repository().findById(feedbackSubmissionRecorded.get???()).ifPresent(feedbackNotification->{
            
            feedbackNotification // do something
            repository().save(feedbackNotification);

            FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
            feedbackNotificationTriggered.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyAdminOnFeedback(
        FeedbackSubmitted feedbackSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        FeedbackNotification feedbackNotification = new FeedbackNotification();
        repository().save(feedbackNotification);

        FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
        feedbackNotificationTriggered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackSubmitted.userIdquestionAnswerId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getUserId(), Map.class);
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getQuestionAnswerId(), Map.class);

        repository().findById(feedbackSubmitted.get???()).ifPresent(feedbackNotification->{
            
            feedbackNotification // do something
            repository().save(feedbackNotification);

            FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
            feedbackNotificationTriggered.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void triggerAdminNotificationOnThreshold(
        FeedbackRecorded feedbackRecorded
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        FeedbackNotification feedbackNotification = new FeedbackNotification();
        repository().save(feedbackNotification);

        FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
        feedbackNotificationTriggered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackRecorded.questionAnswerId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackNotificationStatisticsMap = mapper.convertValue(feedbackRecorded.getQuestionAnswerId(), Map.class);

        repository().findById(feedbackRecorded.get???()).ifPresent(feedbackNotification->{
            
            feedbackNotification // do something
            repository().save(feedbackNotification);

            FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
            feedbackNotificationTriggered.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void feedbackTriggersAdminNotification(
        AnswerFeedbackSubmitted answerFeedbackSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        FeedbackNotification feedbackNotification = new FeedbackNotification();
        repository().save(feedbackNotification);

        FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
        feedbackNotificationTriggered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if answerFeedbackSubmitted.sourceEvidenceIdknowledgeSyncId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> answerGenerationMap = mapper.convertValue(answerFeedbackSubmitted.getSourceEvidenceId(), Map.class);
        // Map<Long, Object> answerGenerationMap = mapper.convertValue(answerFeedbackSubmitted.getKnowledgeSyncId(), Map.class);

        repository().findById(answerFeedbackSubmitted.get???()).ifPresent(feedbackNotification->{
            
            feedbackNotification // do something
            repository().save(feedbackNotification);

            FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
            feedbackNotificationTriggered.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void negativeFeedbackAlert(
        FeedbackSubmitted feedbackSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        FeedbackNotification feedbackNotification = new FeedbackNotification();
        repository().save(feedbackNotification);

        FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
        feedbackNotificationTriggered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackSubmitted.userIdquestionAnswerId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getUserId(), Map.class);
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getQuestionAnswerId(), Map.class);

        repository().findById(feedbackSubmitted.get???()).ifPresent(feedbackNotification->{
            
            feedbackNotification // do something
            repository().save(feedbackNotification);

            FeedbackNotificationTriggered feedbackNotificationTriggered = new FeedbackNotificationTriggered(feedbackNotification);
            feedbackNotificationTriggered.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
