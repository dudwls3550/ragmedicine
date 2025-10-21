package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class QuestionAnswerHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<QuestionAnswer>> {

    @Override
    public EntityModel<QuestionAnswer> process(
        EntityModel<QuestionAnswer> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "submitquestion")
                .withRel("ubmitquestion")
        );

        return model;
    }
}
