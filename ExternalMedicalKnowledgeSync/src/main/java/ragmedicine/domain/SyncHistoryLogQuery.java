package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class SyncHistoryLogQuery {

    private Long syncId;
    private Date startDate;
    private Date endDate;
}
