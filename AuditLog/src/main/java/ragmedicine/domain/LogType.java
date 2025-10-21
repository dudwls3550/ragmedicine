package ragmedicine.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum LogType {
    QNA_ACTIVITY,
    ADMIN_ACTIVITY,
    USER_MANAGEMENT,
    EXTERNAL_SYNC,
}
