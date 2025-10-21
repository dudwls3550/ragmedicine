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
    collectionResourceRel = "answerGenerations",
    path = "answerGenerations"
)
public interface AnswerGenerationRepository
    extends PagingAndSortingRepository<AnswerGeneration, Long> {
    @Query(
        value = "select answerGeneration " +
        "from AnswerGeneration answerGeneration " +
        "where(:answerGenerationId is null or answerGeneration.answerGenerationId = :answerGenerationId)"
    )
    List<AnswerGeneration> feedbackSummary(
        Long answerGenerationId,
        Pageable pageable
    );

    @Query(
        value = "select answerGeneration " +
        "from AnswerGeneration answerGeneration " +
        "where(:answerGenerationId is null or answerGeneration.answerGenerationId = :answerGenerationId)"
    )
    AnswerGeneration answerDetail(Long answerGenerationId);
}
