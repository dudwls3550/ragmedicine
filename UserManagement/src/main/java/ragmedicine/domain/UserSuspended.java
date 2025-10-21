package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserSuspended extends AbstractEvent {

    private Long userId;
    private UserStatus status;
    private String suspendedReason;
    private Date suspendedAt;

    public UserSuspended(User aggregate) {
        super(aggregate);
    }

    public UserSuspended() {
        super();
    }
}
//>>> DDD / Domain Event
