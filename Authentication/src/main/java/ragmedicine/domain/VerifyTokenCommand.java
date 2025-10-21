package ragmedicine.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class VerifyTokenCommand {

    private Long tokenId;
    private String tokenValue;
}
