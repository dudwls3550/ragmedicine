package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserActivated extends AbstractEvent {

    private Long userId;
    private UserStatus status;
    private Date updatedAt;

    public UserActivated(User aggregate) {
        super(aggregate);
    }

    public UserActivated() {
        super();
    }
}
//>>> DDD / Domain Event
