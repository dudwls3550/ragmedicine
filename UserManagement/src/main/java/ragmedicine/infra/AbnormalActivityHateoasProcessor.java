package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class AbnormalActivityHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AbnormalActivity>> {

    @Override
    public EntityModel<AbnormalActivity> process(
        EntityModel<AbnormalActivity> model
    ) {
        return model;
    }
}
