package ragmedicine.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ragmedicine.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/authenticationTokens")
@Transactional
public class AuthenticationTokenController {

    @Autowired
    AuthenticationTokenRepository authenticationTokenRepository;
}
//>>> Clean Arch / Inbound Adaptor
