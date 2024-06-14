package com.mysite.ssb.user;

import com.mysite.ssb.DataNotFoundException;
import java.util.Optional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Builder
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password) {
        SiteUser siteUser = SiteUser.builder()
                .username(username)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();

        this.userRepository.save(siteUser);
        return siteUser;
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("Site user not found");
        }
    }
}
