package hansung.ac.kr.academicinformationsystem.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "Authorities")
public class Authorities {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @Column
    private String authority;
}
