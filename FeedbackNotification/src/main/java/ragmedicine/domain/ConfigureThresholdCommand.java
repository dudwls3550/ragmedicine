package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ConfigureThresholdCommand {

    private Long feedbackStatisticsId;
    private Double dissatisfactionRatioThreshold;
}
