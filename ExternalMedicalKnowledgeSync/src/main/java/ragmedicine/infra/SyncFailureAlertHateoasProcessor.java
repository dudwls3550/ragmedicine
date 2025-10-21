package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class SyncFailureAlertHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<SyncFailureAlert>> {

    @Override
    public EntityModel<SyncFailureAlert> process(
        EntityModel<SyncFailureAlert> model
    ) {
        return model;
    }
}
