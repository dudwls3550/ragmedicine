package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class AccessGranted extends AbstractEvent {

    private Long authorizationId;
    private Long userId;
    private AuthorizationLevel level;
    private AuthorizationStatus status;
    private Date grantedAt;

    public AccessGranted(Authorization aggregate) {
        super(aggregate);
    }

    public AccessGranted() {
        super();
    }
}
//>>> DDD / Domain Event
