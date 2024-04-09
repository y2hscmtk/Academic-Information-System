package hansung.ac.kr.academicinformationsystem.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

// Authorities 테이블과 다대일 관계
// User ------- Authorities
//     1       *
// 하나의 사용자는 여러개의 권한을 가질 수 있음
@Entity @Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "User")
public class Users {
    @Id @Column(name = "username")
    public String username;
    public String email;
    public String password;

    // Authorities 매핑
    @OneToMany(mappedBy = "users")
    private Set<Authorities> authorities;

}
