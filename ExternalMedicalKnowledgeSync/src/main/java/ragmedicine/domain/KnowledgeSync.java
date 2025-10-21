package ragmedicine.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ragmedicine.ExternalMedicalKnowledgeSyncApplication;

@Entity
@Table(name = "KnowledgeSync_table")
@Data
//<<< DDD / Aggregate Root
public class KnowledgeSync {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long syncId;

    private String externalDbStatus;

    private Date lastSyncedAt;

    private String syncCycle;

    private String syncData;

    private String syncLog;

    private SyncStatus syncStatus;

    private Date createdAt;

    private Date updatedAt;

    public static KnowledgeSyncRepository repository() {
        KnowledgeSyncRepository knowledgeSyncRepository = ExternalMedicalKnowledgeSyncApplication.applicationContext.getBean(
            KnowledgeSyncRepository.class
        );
        return knowledgeSyncRepository;
    }
}
//>>> DDD / Aggregate Root
