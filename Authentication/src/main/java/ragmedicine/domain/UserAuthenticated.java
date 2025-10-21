package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserAuthenticated extends AbstractEvent {

    private Long tokenId;
    private Long userId;
    private String tokenValue;
    private Date issuedAt;
    private Date expiresAt;
    private TokenStatus status;

    public UserAuthenticated(AuthenticationToken aggregate) {
        super(aggregate);
    }

    public UserAuthenticated() {
        super();
    }
}
//>>> DDD / Domain Event
