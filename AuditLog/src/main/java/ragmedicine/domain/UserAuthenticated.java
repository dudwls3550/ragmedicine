package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class UserAuthenticated extends AbstractEvent {

    private Long tokenId;
    private Long userId;
    private String tokenValue;
    private Date issuedAt;
    private Date expiresAt;
    private Object status;
}
