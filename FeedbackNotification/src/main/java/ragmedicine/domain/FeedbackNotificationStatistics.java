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
@Table(name = "FeedbackNotificationStatistics_table")
@Data
//<<< DDD / Aggregate Root
public class FeedbackNotificationStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedbackStatisticsId;

    private Long totalFeedbackCount;

    private Long dissatisfiedFeedbackCount;

    private Double dissatisfiedFeedbackRatio;

    private Date aggregatedAt;

    @Embedded
    private QuestionAnswerId questionAnswerId;

    public static FeedbackNotificationStatisticsRepository repository() {
        FeedbackNotificationStatisticsRepository feedbackNotificationStatisticsRepository = FeedbackNotificationApplication.applicationContext.getBean(
            FeedbackNotificationStatisticsRepository.class
        );
        return feedbackNotificationStatisticsRepository;
    }

    //<<< Clean Arch / Port Method
    public static void recordFeedbackForStatistics(
        FeedbackSubmitted feedbackSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        FeedbackNotificationStatistics feedbackNotificationStatistics = new FeedbackNotificationStatistics();
        repository().save(feedbackNotificationStatistics);

        FeedbackSubmissionRecorded feedbackSubmissionRecorded = new FeedbackSubmissionRecorded(feedbackNotificationStatistics);
        feedbackSubmissionRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackSubmitted.userIdquestionAnswerId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getUserId(), Map.class);
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getQuestionAnswerId(), Map.class);

        repository().findById(feedbackSubmitted.get???()).ifPresent(feedbackNotificationStatistics->{
            
            feedbackNotificationStatistics // do something
            repository().save(feedbackNotificationStatistics);

            FeedbackSubmissionRecorded feedbackSubmissionRecorded = new FeedbackSubmissionRecorded(feedbackNotificationStatistics);
            feedbackSubmissionRecorded.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void recordSubmittedFeedback(
        FeedbackSubmitted feedbackSubmitted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        FeedbackNotificationStatistics feedbackNotificationStatistics = new FeedbackNotificationStatistics();
        repository().save(feedbackNotificationStatistics);

        FeedbackRecorded feedbackRecorded = new FeedbackRecorded(feedbackNotificationStatistics);
        feedbackRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if feedbackSubmitted.userIdquestionAnswerId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getUserId(), Map.class);
        // Map<Long, Object> feedbackMap = mapper.convertValue(feedbackSubmitted.getQuestionAnswerId(), Map.class);

        repository().findById(feedbackSubmitted.get???()).ifPresent(feedbackNotificationStatistics->{
            
            feedbackNotificationStatistics // do something
            repository().save(feedbackNotificationStatistics);

            FeedbackRecorded feedbackRecorded = new FeedbackRecorded(feedbackNotificationStatistics);
            feedbackRecorded.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
