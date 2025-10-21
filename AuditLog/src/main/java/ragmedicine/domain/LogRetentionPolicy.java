package ragmedicine.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ragmedicine.AuditLogApplication;

@Entity
@Table(name = "LogRetentionPolicy_table")
@Data
//<<< DDD / Aggregate Root
public class LogRetentionPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long logRetentionPolicyId;

    private String policyName;

    private Integer retentionPeriodYears;

    private Boolean isActive;

    private Date createdAt;

    private Date updatedAt;

    @Embedded
    private AuditLogId auditLogId;

    public static LogRetentionPolicyRepository repository() {
        LogRetentionPolicyRepository logRetentionPolicyRepository = AuditLogApplication.applicationContext.getBean(
            LogRetentionPolicyRepository.class
        );
        return logRetentionPolicyRepository;
    }

    //<<< Clean Arch / Port Method
    public static void logSuccessfulKnowledgeSync(
        ExternalKnowledgeSynchronized externalKnowledgeSynchronized
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        LogRetentionPolicy logRetentionPolicy = new LogRetentionPolicy();
        repository().save(logRetentionPolicy);

        LogRecorded logRecorded = new LogRecorded(logRetentionPolicy);
        logRecorded.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(externalKnowledgeSynchronized.get???()).ifPresent(logRetentionPolicy->{
            
            logRetentionPolicy // do something
            repository().save(logRetentionPolicy);

            LogRecorded logRecorded = new LogRecorded(logRetentionPolicy);
            logRecorded.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
