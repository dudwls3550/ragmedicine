package ragmedicine.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ragmedicine.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "authenticationTokens",
    path = "authenticationTokens"
)
public interface AuthenticationTokenRepository
    extends PagingAndSortingRepository<AuthenticationToken, String> {
    @Query(
        value = "select authenticationToken " +
        "from AuthenticationToken authenticationToken " +
        "where(:tokenId is null or authenticationToken.tokenId = :tokenId)"
    )
    AuthenticationToken tokenDetails(Long tokenId);

    @Query(
        value = "select authenticationToken " +
        "from AuthenticationToken authenticationToken " +
        "where(:userId is null or authenticationToken.userId = :userId)"
    )
    AuthenticationToken authenticationSession(Long userId);

    @Query(
        value = "select authenticationToken " +
        "from AuthenticationToken authenticationToken " +
        "where(:tokenId is null or authenticationToken.tokenId like %:tokenId%)"
    )
    AuthenticationToken tokenStatus(String tokenId);

    @Query(
        value = "select authenticationToken " +
        "from AuthenticationToken authenticationToken " +
        "where(:userId is null or authenticationToken.userId = :userId)"
    )
    List<AuthenticationToken> authenticationLog(Long userId, Pageable pageable);
}
