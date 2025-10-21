package ragmedicine.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ragmedicine.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/sourceEvidences")
@Transactional
public class SourceEvidenceController {

    @Autowired
    SourceEvidenceRepository sourceEvidenceRepository;

    @RequestMapping(
        value = "/sourceEvidencesretrieveevidence",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public SourceEvidence retrieveEvidence(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RetrieveEvidenceCommand retrieveEvidenceCommand
    ) throws Exception {
        System.out.println(
            "##### /sourceEvidence/retrieveEvidence  called #####"
        );
        SourceEvidence sourceEvidence = new SourceEvidence();
        sourceEvidence.retrieveEvidence(retrieveEvidenceCommand);
        sourceEvidenceRepository.save(sourceEvidence);
        return sourceEvidence;
    }
}
//>>> Clean Arch / Inbound Adaptor
