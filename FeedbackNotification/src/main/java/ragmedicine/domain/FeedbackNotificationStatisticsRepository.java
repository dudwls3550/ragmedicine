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
    collectionResourceRel = "feedbackNotificationStatistics",
    path = "feedbackNotificationStatistics"
)
public interface FeedbackNotificationStatisticsRepository
    extends PagingAndSortingRepository<FeedbackNotificationStatistics, Long> {
    @Query(
        value = "select feedbackNotificationStatistics " +
        "from FeedbackNotificationStatistics feedbackNotificationStatistics " +
        "where(:feedbackStatisticsId is null or feedbackNotificationStatistics.feedbackStatisticsId = :feedbackStatisticsId)"
    )
    FeedbackNotificationStatistics feedbackRatioSummary(
        Long feedbackStatisticsId
    );

    @Query(
        value = "select feedbackNotificationStatistics " +
        "from FeedbackNotificationStatistics feedbackNotificationStatistics " +
        "where(:feedbackStatisticsId is null or feedbackNotificationStatistics.feedbackStatisticsId = :feedbackStatisticsId)"
    )
    FeedbackNotificationStatistics thresholdConfiguration(
        Long feedbackStatisticsId
    );

    @Query(
        value = "select feedbackNotificationStatistics " +
        "from FeedbackNotificationStatistics feedbackNotificationStatistics " +
        "where(:feedbackStatisticsId is null or feedbackNotificationStatistics.feedbackStatisticsId = :feedbackStatisticsId)"
    )
    FeedbackNotificationStatistics feedbackStatisticsSummary(
        Long feedbackStatisticsId
    );

    @Query(
        value = "select feedbackNotificationStatistics " +
        "from FeedbackNotificationStatistics feedbackNotificationStatistics " +
        "where(:feedbackStatisticsId is null or feedbackNotificationStatistics.feedbackStatisticsId = :feedbackStatisticsId)"
    )
    FeedbackNotificationStatistics thresholdConfiguration(
        Long feedbackStatisticsId
    );
}
