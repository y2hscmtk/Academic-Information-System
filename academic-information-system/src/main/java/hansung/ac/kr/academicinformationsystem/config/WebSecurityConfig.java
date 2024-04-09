package hansung.ac.kr.academicinformationsystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin((formLogin) ->
                        formLogin.loginPage("/login") // 커스텀 폼 설정
                                .defaultSuccessUrl("/home",true))
                .authorizeHttpRequests((authorizeRequests) ->
                authorizeRequests
                        .requestMatchers("/grade-detail").authenticated()
                        .requestMatchers("/apply-course").authenticated()
                        .requestMatchers("/my-course").authenticated()
                        .requestMatchers("/total-grade").authenticated()
                        .anyRequest().permitAll()
        );
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(
                User.withUsername("user1")
                        .password("1234")
                        .roles("user").build());
        return inMemoryUserDetailsManager;
    }
}
