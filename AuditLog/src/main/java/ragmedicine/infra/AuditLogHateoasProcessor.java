package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class AuditLogHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AuditLog>> {

    @Override
    public EntityModel<AuditLog> process(EntityModel<AuditLog> model) {
        return model;
    }
}
