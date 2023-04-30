package code.with.me.auth;

import code.with.me.util.GenerateCodeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author andong@xiaomalixing.com
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final OptRepository optRepository;

    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void auth(User user) {
        User dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new BadCredentialsException("User not found"));

        if (!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            throw new BadCredentialsException("bad credentials");
        }

        renewOpt(user);
    }

    private void renewOpt(User user) {
        String uuid = GenerateCodeUtil.generateCode();
        optRepository.findByUsername(user.getUsername())
                .ifPresentOrElse(
                        otp -> otp.setCode(uuid),
                        () -> {
                            Otp otp = new Otp();
                            otp.setUsername(user.getUsername());
                            otp.setCode(uuid);
                            optRepository.save(otp);
                        }
                );
    }

    public boolean check(Otp optToCheck) {
        return optRepository.findByUsername(optToCheck.getUsername())
                .map(otp -> otp.getCode().equals(optToCheck.getCode()))
                .orElse(false);
    }
}
