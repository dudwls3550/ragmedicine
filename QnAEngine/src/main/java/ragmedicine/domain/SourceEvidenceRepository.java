package ragmedicine.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ragmedicine.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "sourceEvidences",
    path = "sourceEvidences"
)
public interface SourceEvidenceRepository
    extends PagingAndSortingRepository<SourceEvidence, Long> {
    @Query(
        value = "select sourceEvidence " +
        "from SourceEvidence sourceEvidence " +
        "where(:answerGenerationId is null or sourceEvidence.answerGenerationId = :answerGenerationId)"
    )
    List<SourceEvidence> sourceCitation(
        Long answerGenerationId,
        Pageable pageable
    );

    @Query(
        value = "select sourceEvidence " +
        "from SourceEvidence sourceEvidence " +
        "where(:knowledgeSyncId is null or sourceEvidence.knowledgeSyncId = :knowledgeSyncId)"
    )
    List<SourceEvidence> knowledgeSourceIndex(
        KnowledgeSyncId knowledgeSyncId,
        Pageable pageable
    );

    @Query(
        value = "select sourceEvidence " +
        "from SourceEvidence sourceEvidence " +
        "where(:answerGenerationId is null or sourceEvidence.answerGenerationId = :answerGenerationId)"
    )
    List<SourceEvidence> evidenceCitationList(
        Long answerGenerationId,
        Pageable pageable
    );

    @Query(
        value = "select sourceEvidence " +
        "from SourceEvidence sourceEvidence " +
        "where(:sourceEvidenceId is null or sourceEvidence.sourceEvidenceId = :sourceEvidenceId)"
    )
    SourceEvidence knowledgeSourceReference(Long sourceEvidenceId);
}
