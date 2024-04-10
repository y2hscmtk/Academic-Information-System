package hansung.ac.kr.academicinformationsystem.repsitory;

import hansung.ac.kr.academicinformationsystem.domain.Course;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CourseRepository{


    private final EntityManager em;


    // 모든 Course정보 조회
    public List<Course> getAllCourses(){
        // 모든 Course정보 얻기(2024-2학기 정보는 제외하도록)
        return em.createQuery("select c from Course c where c.year!=2024 or (c.year = 2024 and c.semester = 1) " +
                        "and c.semester!=2", Course.class)
                .getResultList();
    }

    // 특정 학년 & 학기 정보에 해당하는 Course 정보 조회
    public List<Course> getSpecificCourses(int year, int semester){
        return em.createQuery(
                "select c from Course c where c.year = :year and c.semester = :semester",Course.class)
                .setParameter("year",year)
                .setParameter("semester",semester)
                .getResultList();
    }

    // 수강신청
    @Transactional // 저장
    public void save(Course course){
        em.persist(course);
        em.flush(); // 영속화 해제 -> 커밋
    }

}

