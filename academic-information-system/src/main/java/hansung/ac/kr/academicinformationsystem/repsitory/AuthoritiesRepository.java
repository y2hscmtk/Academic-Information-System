package hansung.ac.kr.academicinformationsystem.repsitory;

import hansung.ac.kr.academicinformationsystem.domain.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities,String> {

}
