package ragmedicine.infra;
import ragmedicine.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/answerGenerations")
@Transactional
public class AnswerGenerationController {
    @Autowired
    AnswerGenerationRepository answerGenerationRepository;

    @RequestMapping(value = "/answerGenerations/{id}/submitfeedback",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public AnswerGeneration submitFeedback(@PathVariable(value = "id")  id, @RequestBody SubmitFeedbackCommand submitFeedbackCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /answerGeneration/submitFeedback  called #####");
            Optional<AnswerGeneration> optionalAnswerGeneration = answerGenerationRepository.findById(id);
            
            optionalAnswerGeneration.orElseThrow(()-> new Exception("No Entity Found"));
            AnswerGeneration answerGeneration = optionalAnswerGeneration.get();
            answerGeneration.submitFeedback(submitFeedbackCommand);
            
            answerGenerationRepository.save(answerGeneration);
            return answerGeneration;
            
    }
}
//>>> Clean Arch / Inbound Adaptor
