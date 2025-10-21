package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AnalyzeUserActivityCommand {

    private UserId userId;
    private String activityLogReference;
}
