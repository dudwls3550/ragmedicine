package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class AnswerGenerationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AnswerGeneration>> {

    @Override
    public EntityModel<AnswerGeneration> process(
        EntityModel<AnswerGeneration> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/submitfeedback")
                .withRel("submitfeedback")
        );

        return model;
    }
}
