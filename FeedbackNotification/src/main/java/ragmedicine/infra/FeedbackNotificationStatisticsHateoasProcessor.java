package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class FeedbackNotificationStatisticsHateoasProcessor
    implements
        RepresentationModelProcessor<EntityModel<FeedbackNotificationStatistics>> {

    @Override
    public EntityModel<FeedbackNotificationStatistics> process(
        EntityModel<FeedbackNotificationStatistics> model
    ) {
        return model;
    }
}
