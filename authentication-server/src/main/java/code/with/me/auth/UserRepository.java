package code.with.me.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author andong@xiaomalixing.com
 */
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
