package ragmedicine.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum QuestionStatus {
    SUBMITTED,
    VALIDATION_FAILED,
    ANSWER_PENDING,
    ANSWERED,
}
