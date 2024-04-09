package hansung.ac.kr.academicinformationsystem.service;

import hansung.ac.kr.academicinformationsystem.domain.Authorities;
import hansung.ac.kr.academicinformationsystem.domain.Users;
import hansung.ac.kr.academicinformationsystem.repsitory.AuthoritiesRepository;
import hansung.ac.kr.academicinformationsystem.repsitory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 사용자 DB에서 조회
        Users user = userRepository.findByUsername(username);
        // 존재하지 않는 사용자라면
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // 사용자의 권한 조회
        Set<Authorities> authorities = authoritiesRepository.getUserAuthorities(username);

        // 스프링 시큐리티 UserDetails 객체 생성
        return new User(user.getUsername(), user.getPassword(), authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toSet()));
    }
}
