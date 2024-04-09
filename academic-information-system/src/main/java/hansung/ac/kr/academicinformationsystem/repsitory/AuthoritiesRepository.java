package hansung.ac.kr.academicinformationsystem.repsitory;

import hansung.ac.kr.academicinformationsystem.domain.Authorities;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
@RequiredArgsConstructor
public class AuthoritiesRepository{

    private final EntityManager em;

    // 1. 사용자 권한 확인
    public Set<Authorities> getUserAuthorities(String username) {
        List<Authorities> authorities = em.createQuery("select a from Authorities a where a.users.username = :username", Authorities.class)
                .setParameter("username", username)
                .getResultList();
        return new HashSet<>(authorities);
    }

}
