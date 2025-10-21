package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubmitFollowUpQuestionCommand {

    private Long residentId;
    private Long parentQuestionAnswerId;
    private String followUpContent;
}
