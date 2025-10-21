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
    collectionResourceRel = "abnormalActivities",
    path = "abnormalActivities"
)
public interface AbnormalActivityRepository
    extends PagingAndSortingRepository<AbnormalActivity, Long> {
    @Query(
        value = "select abnormalActivity " +
        "from AbnormalActivity abnormalActivity " +
        "where(:activityType is null or abnormalActivity.activityType = :activityType)"
    )
    AbnormalActivity activityDetectionConfiguration(
        AbnormalActivityType activityType
    );

    @Query(
        value = "select abnormalActivity " +
        "from AbnormalActivity abnormalActivity " +
        "where(:userId is null or abnormalActivity.userId = :userId) and (:status is null or abnormalActivity.status = :status) and (:startDate is null or abnormalActivity.startDate = :startDate)"
    )
    List<AbnormalActivity> abnormalActivityReport(
        UserId userId,
        AbnormalActivityStatus status,
        Date startDate,
        Pageable pageable
    );

    @Query(
        value = "select abnormalActivity " +
        "from AbnormalActivity abnormalActivity " +
        "where(:status is null or abnormalActivity.status = :status)"
    )
    List<AbnormalActivity> abnormalActivityQueue(
        AbnormalActivityStatus status,
        Pageable pageable
    );

    @Query(
        value = "select abnormalActivity " +
        "from AbnormalActivity abnormalActivity " +
        "where(:abnormalActivityId is null or abnormalActivity.abnormalActivityId = :abnormalActivityId) and (:userId is null or abnormalActivity.userId = :userId)"
    )
    AbnormalActivity activityDetectionReport(
        Long abnormalActivityId,
        UserId userId
    );
}
