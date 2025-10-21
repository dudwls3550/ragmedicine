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
// @RequestMapping(value="/feedbacks")
@Transactional
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;

    @RequestMapping(
        value = "/feedbackssubmitfeedback",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Feedback submitFeedback(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SubmitFeedbackCommand submitFeedbackCommand
    ) throws Exception {
        System.out.println("##### /feedback/submitFeedback  called #####");
        Feedback feedback = new Feedback();
        feedback.submitFeedback(submitFeedbackCommand);
        feedbackRepository.save(feedback);
        return feedback;
    }
}
//>>> Clean Arch / Inbound Adaptor
