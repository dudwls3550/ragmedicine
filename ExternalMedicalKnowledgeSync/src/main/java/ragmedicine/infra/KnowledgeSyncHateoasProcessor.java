package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class KnowledgeSyncHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<KnowledgeSync>> {

    @Override
    public EntityModel<KnowledgeSync> process(
        EntityModel<KnowledgeSync> model
    ) {
        return model;
    }
}
