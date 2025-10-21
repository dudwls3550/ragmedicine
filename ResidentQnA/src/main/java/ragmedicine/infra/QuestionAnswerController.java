package ragmedicine.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ragmedicine.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/questionAnswers")
@Transactional
public class QuestionAnswerController {

    @Autowired
    QuestionAnswerRepository questionAnswerRepository;

    @RequestMapping(
        value = "/questionAnswerssubmitquestion",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public QuestionAnswer submitQuestion(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SubmitQuestionCommand submitQuestionCommand
    ) throws Exception {
        System.out.println(
            "##### /questionAnswer/submitQuestion  called #####"
        );
        QuestionAnswer questionAnswer = new QuestionAnswer();
        questionAnswer.submitQuestion(submitQuestionCommand);
        questionAnswerRepository.save(questionAnswer);
        return questionAnswer;
    }
}
//>>> Clean Arch / Inbound Adaptor
