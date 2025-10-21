package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class LogRetentionPolicyHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<LogRetentionPolicy>> {

    @Override
    public EntityModel<LogRetentionPolicy> process(
        EntityModel<LogRetentionPolicy> model
    ) {
        return model;
    }
}
