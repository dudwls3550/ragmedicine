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
    collectionResourceRel = "feedbackNotifications",
    path = "feedbackNotifications"
)
public interface FeedbackNotificationRepository
    extends PagingAndSortingRepository<FeedbackNotification, Long> {
    @Query(
        value = "select feedbackNotification " +
        "from FeedbackNotification feedbackNotification " +
        "where(:adminId is null or feedbackNotification.adminId = :adminId) and (:notificationStatus is null or feedbackNotification.notificationStatus = :notificationStatus)"
    )
    List<FeedbackNotification> notificationHistory(
        Long adminId,
        NotificationStatus notificationStatus,
        Pageable pageable
    );

    @Query(
        value = "select feedbackNotification " +
        "from FeedbackNotification feedbackNotification " +
        "where(:notificationId is null or feedbackNotification.notificationId = :notificationId)"
    )
    FeedbackNotification notificationAlertStatus(Long notificationId);

    @Query(
        value = "select feedbackNotification " +
        "from FeedbackNotification feedbackNotification " +
        "where(:adminId is null or feedbackNotification.adminId = :adminId)"
    )
    List<FeedbackNotification> notificationHistory(
        Long adminId,
        Pageable pageable
    );
}
