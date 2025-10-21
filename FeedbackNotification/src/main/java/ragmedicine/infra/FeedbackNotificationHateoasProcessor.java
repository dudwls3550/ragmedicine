package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class FeedbackNotificationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<FeedbackNotification>> {

    @Override
    public EntityModel<FeedbackNotification> process(
        EntityModel<FeedbackNotification> model
    ) {
        return model;
    }
}
