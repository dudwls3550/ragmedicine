package ragmedicine.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import ragmedicine.domain.*;

@Component
public class SourceEvidenceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<SourceEvidence>> {

    @Override
    public EntityModel<SourceEvidence> process(
        EntityModel<SourceEvidence> model
    ) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() + "retrieveevidence"
                )
                .withRel("etrieveevidence")
        );

        return model;
    }
}
