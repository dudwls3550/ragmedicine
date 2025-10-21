package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ConfigureAlertRecipientsCommand {

    private Long systemConfigurationId;
    private List<String> recipientEmails;
}
