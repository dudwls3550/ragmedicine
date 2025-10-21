package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class FeedbackSummaryQuery {

    private Long residentId;
    private Long questionAnswerId;
}
