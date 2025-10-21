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
    collectionResourceRel = "syncFailureAlerts",
    path = "syncFailureAlerts"
)
public interface SyncFailureAlertRepository
    extends PagingAndSortingRepository<SyncFailureAlert, Long> {
    @Query(
        value = "select syncFailureAlert " +
        "from SyncFailureAlert syncFailureAlert " +
        "where(:alertStatus is null or syncFailureAlert.alertStatus = :alertStatus)"
    )
    List<SyncFailureAlert> activeFailureAlerts(
        AlertStatus alertStatus,
        Pageable pageable
    );

    @Query(
        value = "select syncFailureAlert " +
        "from SyncFailureAlert syncFailureAlert " +
        "where(:syncId is null or syncFailureAlert.syncId = :syncId)"
    )
    List<SyncFailureAlert> alertHistory(Long syncId, Pageable pageable);

    @Query(
        value = "select syncFailureAlert " +
        "from SyncFailureAlert syncFailureAlert " +
        "where(:alertStatusFilter is null or syncFailureAlert.alertStatusFilter = :alertStatusFilter)"
    )
    List<SyncFailureAlert> activeFailureAlerts(
        AlertStatus alertStatusFilter,
        Pageable pageable
    );

    @Query(
        value = "select syncFailureAlert " +
        "from SyncFailureAlert syncFailureAlert " +
        "where(:startDate is null or syncFailureAlert.startDate = :startDate) and (:endDate is null or syncFailureAlert.endDate = :endDate) and (:syncId is null or syncFailureAlert.syncId = :syncId)"
    )
    List<SyncFailureAlert> alertHistory(
        Date startDate,
        Date endDate,
        Long syncId,
        Pageable pageable
    );
}
