package ragmedicine.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ragmedicine.UserManagementApplication;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String encryptedPassword;

    private UserRole role;

    private UserStatus status;

    private Integer abnormalActivityCount;

    private Integer feedbackDissatisfactionCount;

    private Date lastLoginAt;

    private Date createdAt;

    private Date updatedAt;

    private Date suspendedAt;

    private String suspendedReason;

    private UserProfile profile;

    private MedicalInstitutionVerification verification;

    public static UserRepository repository() {
        UserRepository userRepository = UserManagementApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }

    //<<< Clean Arch / Port Method
    public static void suspendUserOnAbnormalActivity(
        AbnormalActivityDetected abnormalActivityDetected
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        User user = new User();
        repository().save(user);

        UserSuspended userSuspended = new UserSuspended(user);
        userSuspended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if abnormalActivityDetected.auditLogIduserIdfeedbackNotificationId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> abnormalActivityMap = mapper.convertValue(abnormalActivityDetected.getAuditLogId(), Map.class);
        // Map<Long, Object> abnormalActivityMap = mapper.convertValue(abnormalActivityDetected.getUserId(), Map.class);
        // Map<Long, Object> abnormalActivityMap = mapper.convertValue(abnormalActivityDetected.getFeedbackNotificationId(), Map.class);

        repository().findById(abnormalActivityDetected.get???()).ifPresent(user->{
            
            user // do something
            repository().save(user);

            UserSuspended userSuspended = new UserSuspended(user);
            userSuspended.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void suspendUserOnAbnormalActivity(
        AbnormalActivityDetected abnormalActivityDetected
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        User user = new User();
        repository().save(user);

        UserSuspended userSuspended = new UserSuspended(user);
        userSuspended.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if abnormalActivityDetected.auditLogIduserIdfeedbackNotificationId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> abnormalActivityMap = mapper.convertValue(abnormalActivityDetected.getAuditLogId(), Map.class);
        // Map<Long, Object> abnormalActivityMap = mapper.convertValue(abnormalActivityDetected.getUserId(), Map.class);
        // Map<Long, Object> abnormalActivityMap = mapper.convertValue(abnormalActivityDetected.getFeedbackNotificationId(), Map.class);

        repository().findById(abnormalActivityDetected.get???()).ifPresent(user->{
            
            user // do something
            repository().save(user);

            UserSuspended userSuspended = new UserSuspended(user);
            userSuspended.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
