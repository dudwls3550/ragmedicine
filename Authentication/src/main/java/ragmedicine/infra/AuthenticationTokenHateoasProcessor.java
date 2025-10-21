package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class AuthenticationTokenHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AuthenticationToken>> {

    @Override
    public EntityModel<AuthenticationToken> process(
        EntityModel<AuthenticationToken> model
    ) {
        return model;
    }
}
