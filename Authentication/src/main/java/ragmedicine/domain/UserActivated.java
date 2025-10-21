package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class UserActivated extends AbstractEvent {

    private Long userId;
    private Object status;
    private Date updatedAt;
}
