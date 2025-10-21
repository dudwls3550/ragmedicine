package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TokenRevoked extends AbstractEvent {

    private Long tokenId;
    private Long userId;
    private Date revocationDate;
    private String reason;

    public TokenRevoked(AuthenticationToken aggregate) {
        super(aggregate);
    }

    public TokenRevoked() {
        super();
    }
}
//>>> DDD / Domain Event
