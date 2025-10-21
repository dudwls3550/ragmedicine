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
@Table(name = "QuestionAnswer_table")
@Data
//<<< DDD / Aggregate Root
public class QuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionAnswerId;

    private Long residentId;

    private String questionContent;

    private QuestionStatus questionStatus;

    private String validationResult;

    private String answerContent;

    private String answerSource;

    private Date answerGeneratedAt;

    private Date createdAt;

    private Date updatedAt;

    private AnswerStatus answerStatus;

    @Embedded
    private UserId userId;

    @Embedded
    private AnswerGenerationId answerGenerationId;

    public static QuestionAnswerRepository repository() {
        QuestionAnswerRepository questionAnswerRepository = ResidentQnAApplication.applicationContext.getBean(
            QuestionAnswerRepository.class
        );
        return questionAnswerRepository;
    }

    //<<< Clean Arch / Port Method
    public void submitQuestion(SubmitQuestionCommand submitQuestionCommand) {
        //implement business logic here:

        QuestionSubmitted questionSubmitted = new QuestionSubmitted(this);
        questionSubmitted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
