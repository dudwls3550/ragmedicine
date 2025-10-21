package ragmedicine.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import ragmedicine.AuthenticationApplication;

@Entity
@Table(name = "Authorization_table")
@Data
//<<< DDD / Aggregate Root
public class Authorization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorizationId;

    private String role;

    private String permissionType;

    private AuthorizationStatus status;

    private AuthorizationLevel level;

    private Date grantedAt;

    private Date revokedAt;

    private Date createdAt;

    private Date updatedAt;

    @Embedded
    private UserId userId;

    public static AuthorizationRepository repository() {
        AuthorizationRepository authorizationRepository = AuthenticationApplication.applicationContext.getBean(
            AuthorizationRepository.class
        );
        return authorizationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void grantAccessUponRegistration(
        UserRegistered userRegistered
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Authorization authorization = new Authorization();
        repository().save(authorization);

        AccessGranted accessGranted = new AccessGranted(authorization);
        accessGranted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(userRegistered.get???()).ifPresent(authorization->{
            
            authorization // do something
            repository().save(authorization);

            AccessGranted accessGranted = new AccessGranted(authorization);
            accessGranted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void restoreAccessUponActivation(
        UserActivated userActivated
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Authorization authorization = new Authorization();
        repository().save(authorization);

        AccessGranted accessGranted = new AccessGranted(authorization);
        accessGranted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(userActivated.get???()).ifPresent(authorization->{
            
            authorization // do something
            repository().save(authorization);

            AccessGranted accessGranted = new AccessGranted(authorization);
            accessGranted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void userRegistrationGrantsPermission(
        UserRegistered userRegistered
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Authorization authorization = new Authorization();
        repository().save(authorization);

        PermissionGranted permissionGranted = new PermissionGranted(authorization);
        permissionGranted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(userRegistered.get???()).ifPresent(authorization->{
            
            authorization // do something
            repository().save(authorization);

            PermissionGranted permissionGranted = new PermissionGranted(authorization);
            permissionGranted.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
