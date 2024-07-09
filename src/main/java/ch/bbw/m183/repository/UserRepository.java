package ch.bbw.m183.repository;

import ch.bbw.m183.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Transactional
    User findByUsername(String username);

//    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username")
//    User findByUsernameWithRoles(@Param("username") String username);
}
