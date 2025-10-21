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
    collectionResourceRel = "logRetentionPolicies",
    path = "logRetentionPolicies"
)
public interface LogRetentionPolicyRepository
    extends PagingAndSortingRepository<LogRetentionPolicy, Long> {
    @Query(
        value = "select logRetentionPolicy " +
        "from LogRetentionPolicy logRetentionPolicy " +
        "where(:logRetentionPolicyId is null or logRetentionPolicy.logRetentionPolicyId = :logRetentionPolicyId)"
    )
    LogRetentionPolicy retentionPolicyConfiguration(Long logRetentionPolicyId);

    @Query(
        value = "select logRetentionPolicy " +
        "from LogRetentionPolicy logRetentionPolicy " +
        "where(:startDate is null or logRetentionPolicy.startDate = :startDate) and (:endDate is null or logRetentionPolicy.endDate = :endDate) and (:logLevel is null or logRetentionPolicy.logLevel = :logLevel) and (:sourceSystemName is null or logRetentionPolicy.sourceSystemName like %:sourceSystemName%)"
    )
    List<LogRetentionPolicy> auditLogSummary(
        Date startDate,
        Date endDate,
        LogLevel logLevel,
        String sourceSystemName,
        Pageable pageable
    );

    @Query(
        value = "select logRetentionPolicy " +
        "from LogRetentionPolicy logRetentionPolicy " +
        "where(:userId is null or logRetentionPolicy.userId = :userId) and (:startDate is null or logRetentionPolicy.startDate = :startDate) and (:endDate is null or logRetentionPolicy.endDate = :endDate) and (:eventType is null or logRetentionPolicy.eventType = :eventType)"
    )
    List<LogRetentionPolicy> activityHistory(
        Long userId,
        Date startDate,
        Date endDate,
        LogType eventType,
        Pageable pageable
    );
}
