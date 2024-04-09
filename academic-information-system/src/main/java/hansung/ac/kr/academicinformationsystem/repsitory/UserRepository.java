package hansung.ac.kr.academicinformationsystem.repsitory;

import hansung.ac.kr.academicinformationsystem.domain.Users;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@RequiredArgsConstructor
@Transactional
public class UserRepository {

    private final EntityManager em;

    // 1. 해당하는 사용자 DB에서 조회 // username이 아이디에 해당하므로 해당하는 사용자가 있는지 먼저 확인한다.
    public Users findByUsername(String name) {
        return em.find(Users.class, name);
    }

}
