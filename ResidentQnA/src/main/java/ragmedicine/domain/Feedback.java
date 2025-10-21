package ragmedicine.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ragmedicine.ResidentQnAApplication;

@Entity
@Table(name = "Feedback_table")
@Data
//<<< DDD / Aggregate Root
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedbackId;

    private Long residentId;

    private String feedbackContent;

    private FeedbackType feedbackType;

    private FeedbackStatus feedbackStatus;

    private Boolean adminNotificationSent;

    private Date createdAt;

    private Date updatedAt;

    @Embedded
    private UserId userId;

    @Embedded
    private QuestionAnswerId questionAnswerId;

    public static FeedbackRepository repository() {
        FeedbackRepository feedbackRepository = ResidentQnAApplication.applicationContext.getBean(
            FeedbackRepository.class
        );
        return feedbackRepository;
    }

    //<<< Clean Arch / Port Method
    public void submitFeedback(SubmitFeedbackCommand submitFeedbackCommand) {
        //implement business logic here:

        FeedbackSubmitted feedbackSubmitted = new FeedbackSubmitted(this);
        feedbackSubmitted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
