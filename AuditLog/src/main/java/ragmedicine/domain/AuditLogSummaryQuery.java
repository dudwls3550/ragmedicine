package ragmedicine.domain;

import java.util.Date;
import lombok.Data;

@Data
public class AuditLogSummaryQuery {

    private Date startDate;
    private Date endDate;
    private LogLevel logLevel;
    private String sourceSystemName;
}
