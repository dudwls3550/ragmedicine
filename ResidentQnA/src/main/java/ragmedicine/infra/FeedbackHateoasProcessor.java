package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class FeedbackHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Feedback>> {

    @Override
    public EntityModel<Feedback> process(EntityModel<Feedback> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "submitfeedback")
                .withRel("ubmitfeedback")
        );

        return model;
    }
}
