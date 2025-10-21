package ragmedicine.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ragmedicine.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "feedbacks", path = "feedbacks")
public interface FeedbackRepository
    extends PagingAndSortingRepository<Feedback, Long> {
    @Query(
        value = "select feedback " +
        "from Feedback feedback " +
        "where(:residentId is null or feedback.residentId = :residentId) and (:questionAnswerId is null or feedback.questionAnswerId = :questionAnswerId)"
    )
    List<Feedback> feedbackSummary(
        Long residentId,
        Long questionAnswerId,
        Pageable pageable
    );

    @Query(
        value = "select feedback " +
        "from Feedback feedback " +
        "where(:feedbackId is null or feedback.feedbackId = :feedbackId)"
    )
    Feedback feedbackDetail(Long feedbackId);

    @Query(
        value = "select feedback " +
        "from Feedback feedback " +
        "where(:residentId is null or feedback.residentId = :residentId) and (:feedbackStatus is null or feedback.feedbackStatus = :feedbackStatus)"
    )
    List<Feedback> feedbackSummary(
        Long residentId,
        FeedbackStatus feedbackStatus,
        Pageable pageable
    );

    @Query(
        value = "select feedback " +
        "from Feedback feedback " +
        "where(:feedbackId is null or feedback.feedbackId = :feedbackId)"
    )
    Feedback feedbackDetail(Long feedbackId);
}
