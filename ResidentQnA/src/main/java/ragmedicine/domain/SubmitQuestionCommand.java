package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubmitQuestionCommand {

    private Long residentId;
    private String questionContent;
}
