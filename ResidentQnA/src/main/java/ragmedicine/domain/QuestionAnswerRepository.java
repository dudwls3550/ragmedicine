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
    collectionResourceRel = "questionAnswers",
    path = "questionAnswers"
)
public interface QuestionAnswerRepository
    extends PagingAndSortingRepository<QuestionAnswer, Long> {
    @Query(
        value = "select questionAnswer " +
        "from QuestionAnswer questionAnswer " +
        "where(:questionAnswerId is null or questionAnswer.questionAnswerId = :questionAnswerId)"
    )
    QuestionAnswer questionAnswerDetail(Long questionAnswerId);

    @Query(
        value = "select questionAnswer " +
        "from QuestionAnswer questionAnswer " +
        "where(:residentId is null or questionAnswer.residentId = :residentId)"
    )
    List<QuestionAnswer> questionHistory(Long residentId, Pageable pageable);

    @Query(
        value = "select questionAnswer " +
        "from QuestionAnswer questionAnswer " +
        "where(:questionAnswerId is null or questionAnswer.questionAnswerId = :questionAnswerId)"
    )
    QuestionAnswer questionAnswerDetail(Long questionAnswerId);

    @Query(
        value = "select questionAnswer " +
        "from QuestionAnswer questionAnswer " +
        "where(:residentId is null or questionAnswer.residentId = :residentId)"
    )
    List<QuestionAnswer> questionHistory(Long residentId, Pageable pageable);
}
