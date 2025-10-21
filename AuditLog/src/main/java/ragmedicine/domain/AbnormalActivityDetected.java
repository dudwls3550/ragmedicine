package ragmedicine.domain;

import java.util.*;
import lombok.*;
import ragmedicine.domain.*;
import ragmedicine.infra.AbstractEvent;

@Data
@ToString
public class AbnormalActivityDetected extends AbstractEvent {

    private Long abnormalActivityId;
    private Object userId;
    private Date detectedAt;
    private Object activityType;
    private String description;
    private String detectionResult;
    private Object status;
}
