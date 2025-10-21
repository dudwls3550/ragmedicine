package ragmedicine.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ragmedicine.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query(
        value = "select user " +
        "from User user " +
        "where(:userId is null or user.userId = :userId)"
    )
    User userDetail(Long userId);

    @Query(
        value = "select user " +
        "from User user " +
        "where(:userId is null or user.userId = :userId) and (:startDate is null or user.startDate = :startDate) and (:endDate is null or user.endDate = :endDate)"
    )
    List<User> userActivityHistory(
        Long userId,
        Date startDate,
        Date endDate,
        Pageable pageable
    );

    @Query(
        value = "select user " +
        "from User user " +
        "where(:status is null or user.status = :status) and (:role is null or user.role = :role)"
    )
    List<User> userList(UserStatus status, UserRole role, Pageable pageable);

    @Query(
        value = "select user " +
        "from User user " +
        "where(:status is null or user.status = :status)"
    )
    List<User> userList(UserStatus status, Pageable pageable);

    @Query(
        value = "select user " +
        "from User user " +
        "where(:userId is null or user.userId = :userId)"
    )
    User userDetail(Long userId);

    @Query(
        value = "select user " +
        "from User user " +
        "where(:userId is null or user.userId = :userId)"
    )
    List<User> userActivityLog(Long userId, Pageable pageable);
}
