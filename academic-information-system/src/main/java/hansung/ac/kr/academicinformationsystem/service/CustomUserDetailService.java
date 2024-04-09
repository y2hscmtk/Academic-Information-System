package hansung.ac.kr.academicinformationsystem.service;

import hansung.ac.kr.academicinformationsystem.domain.Authorities;
import hansung.ac.kr.academicinformationsystem.domain.User;
import hansung.ac.kr.academicinformationsystem.repsitory.AuthoritiesRepository;
import hansung.ac.kr.academicinformationsystem.repsitory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final AuthoritiesRepository authoritiesRepository;
    private final UserRepository userRepository;

    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 사용자가 실제로 존재하는지 확인
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        // 2. 사용자의 모든 권한 얻기
        Set<Authorities> authorities = authoritiesRepository.getUserAuthorities(username);
        Set<SimpleGrantedAuthority> grantedAuthorities = authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toSet());


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),grantedAuthorities);
    }
}
