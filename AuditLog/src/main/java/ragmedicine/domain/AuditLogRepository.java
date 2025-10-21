package ragmedicine.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ragmedicine.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "auditLogs", path = "auditLogs")
public interface AuditLogRepository
    extends PagingAndSortingRepository<AuditLog, Long> {
    @Query(
        value = "select auditLog " +
        "from AuditLog auditLog " +
        "where(:actorId is null or auditLog.actorId = :actorId) and (:eventType is null or auditLog.eventType = :eventType)"
    )
    List<AuditLog> activityLogSummary(
        Long actorId,
        LogType eventType,
        Pageable pageable
    );

    @Query(
        value = "select auditLog " +
        "from AuditLog auditLog " +
        "where(:auditLogId is null or auditLog.auditLogId = :auditLogId)"
    )
    AuditLog auditLogEntry(Long auditLogId);

    @Query(
        value = "select auditLog " +
        "from AuditLog auditLog " +
        "where(:logRetentionPolicyId is null or auditLog.logRetentionPolicyId = :logRetentionPolicyId)"
    )
    AuditLog retentionPolicyConfiguration(Long logRetentionPolicyId);
}
