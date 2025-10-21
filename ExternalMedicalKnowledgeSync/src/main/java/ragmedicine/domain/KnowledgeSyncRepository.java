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
    collectionResourceRel = "knowledgeSyncs",
    path = "knowledgeSyncs"
)
public interface KnowledgeSyncRepository
    extends PagingAndSortingRepository<KnowledgeSync, Long> {
    @Query(
        value = "select knowledgeSync " +
        "from KnowledgeSync knowledgeSync " +
        "where(:syncId is null or knowledgeSync.syncId = :syncId)"
    )
    KnowledgeSync knowledgeSyncStatus(Long syncId);

    @Query(
        value = "select knowledgeSync " +
        "from KnowledgeSync knowledgeSync " +
        "where(:syncId is null or knowledgeSync.syncId = :syncId)"
    )
    List<KnowledgeSync> syncHistory(Long syncId, Pageable pageable);

    @Query(
        value = "select knowledgeSync " +
        "from KnowledgeSync knowledgeSync " +
        "where(:syncId is null or knowledgeSync.syncId = :syncId) and (:startDate is null or knowledgeSync.startDate = :startDate) and (:endDate is null or knowledgeSync.endDate = :endDate)"
    )
    List<KnowledgeSync> syncHistoryLog(
        Long syncId,
        Date startDate,
        Date endDate,
        Pageable pageable
    );

    @Query(
        value = "select knowledgeSync " +
        "from KnowledgeSync knowledgeSync " +
        "where(:syncId is null or knowledgeSync.syncId = :syncId)"
    )
    KnowledgeSync syncStatusMonitor(Long syncId);
}
