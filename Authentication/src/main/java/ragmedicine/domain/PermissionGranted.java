package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PermissionGranted extends AbstractEvent {

    private Long authorizationId;
    private Long userId;
    private AuthorizationLevel role;
    private String permissionType;
    private Date grantedAt;

    public PermissionGranted(Authorization aggregate) {
        super(aggregate);
    }

    public PermissionGranted() {
        super();
    }
}
//>>> DDD / Domain Event
