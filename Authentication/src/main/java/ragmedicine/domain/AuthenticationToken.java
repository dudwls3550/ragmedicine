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
@Table(name = "AuthenticationToken_table")
@Data
//<<< DDD / Aggregate Root
public class AuthenticationToken {

    @Id
    private String tokenId;

    private String tokenValue;

    private Date issuedAt;

    private Date expiresAt;

    private TokenStatus status;

    private Date lastValidatedAt;

    private Date createdAt;

    private Date updatedAt;

    @Embedded
    private UserId userId;

    public static AuthenticationTokenRepository repository() {
        AuthenticationTokenRepository authenticationTokenRepository = AuthenticationApplication.applicationContext.getBean(
            AuthenticationTokenRepository.class
        );
        return authenticationTokenRepository;
    }

    //<<< Clean Arch / Port Method
    public static void revokeTokenUponSuspension(UserSuspended userSuspended) {
        //implement business logic here:

        /** Example 1:  new item 
        AuthenticationToken authenticationToken = new AuthenticationToken();
        repository().save(authenticationToken);

        TokenRevoked tokenRevoked = new TokenRevoked(authenticationToken);
        tokenRevoked.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(userSuspended.get???()).ifPresent(authenticationToken->{
            
            authenticationToken // do something
            repository().save(authenticationToken);

            TokenRevoked tokenRevoked = new TokenRevoked(authenticationToken);
            tokenRevoked.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
