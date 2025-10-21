package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class AuthorizationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Authorization>> {

    @Override
    public EntityModel<Authorization> process(
        EntityModel<Authorization> model
    ) {
        return model;
    }
}
