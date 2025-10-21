package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class UserRegistered extends AbstractEvent {

    private Long userId;
    private Object profile;
    private Object verification;
    private Object role;
    private Object status;
    private Date createdAt;
}
