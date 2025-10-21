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
    collectionResourceRel = "authorizations",
    path = "authorizations"
)
public interface AuthorizationRepository
    extends PagingAndSortingRepository<Authorization, Long> {
    @Query(
        value = "select authorization " +
        "from Authorization authorization " +
        "where(:status is null or authorization.status = :status) and (:level is null or authorization.level = :level)"
    )
    List<Authorization> permissionList(
        AuthorizationStatus status,
        AuthorizationLevel level,
        Pageable pageable
    );

    @Query(
        value = "select authorization " +
        "from Authorization authorization " +
        "where(:userId is null or authorization.userId = :userId)"
    )
    Authorization userAccessProfile(Long userId);

    @Query(
        value = "select authorization " +
        "from Authorization authorization " +
        "where(:status is null or authorization.status = :status) and (:role is null or authorization.role = :role)"
    )
    List<Authorization> accessControlList(
        AuthorizationStatus status,
        AuthorizationLevel role,
        Pageable pageable
    );

    @Query(
        value = "select authorization " +
        "from Authorization authorization " +
        "where(:userId is null or authorization.userId = :userId)"
    )
    List<Authorization> userPermissions(Long userId, Pageable pageable);
}
