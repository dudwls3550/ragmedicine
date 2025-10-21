package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class UserSuspended extends AbstractEvent {

    private Long userId;
    private Object status;
    private String suspendedReason;
    private Date suspendedAt;
}
