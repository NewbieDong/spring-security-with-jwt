package code.with.me.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author andong@xiaomalixing.com
 */
public interface OptRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findByUsername(String username);
}
