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
@Table(name = "SyncFailureAlert_table")
@Data
//<<< DDD / Aggregate Root
public class SyncFailureAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long alertId;

    private Long syncId;

    private String failureReason;

    private AlertStatus alertStatus;

    private Date notifiedAt;

    @Embedded
    private KnowledgeSyncId knowledgeSyncId;

    public static SyncFailureAlertRepository repository() {
        SyncFailureAlertRepository syncFailureAlertRepository = ExternalMedicalKnowledgeSyncApplication.applicationContext.getBean(
            SyncFailureAlertRepository.class
        );
        return syncFailureAlertRepository;
    }

    //<<< Clean Arch / Port Method
    public static void syncFailureAlerting(
        ExternalKnowledgeSyncFailed externalKnowledgeSyncFailed
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        SyncFailureAlert syncFailureAlert = new SyncFailureAlert();
        repository().save(syncFailureAlert);

        SyncFailureAlertSent syncFailureAlertSent = new SyncFailureAlertSent(syncFailureAlert);
        syncFailureAlertSent.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(externalKnowledgeSyncFailed.get???()).ifPresent(syncFailureAlert->{
            
            syncFailureAlert // do something
            repository().save(syncFailureAlert);

            SyncFailureAlertSent syncFailureAlertSent = new SyncFailureAlertSent(syncFailureAlert);
            syncFailureAlertSent.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
