package hansung.ac.kr.academicinformationsystem.repsitory;

import hansung.ac.kr.academicinformationsystem.domain.Authorities;
import hansung.ac.kr.academicinformationsystem.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Repository
@RequiredArgsConstructor
@Transactional
public class UserRepository {

    private final EntityManager em;

    // 1. 해당하는 사용자 DB에서 조회 // username이 아이디에 해당하므로 해당하는 사용자가 있는지 먼저 확인한다.
    public User findByUsername(String name) {
        return em.find(User.class, name);
    }

}
