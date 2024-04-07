package hansung.ac.kr.academicinformationsystem.repsitory;

import hansung.ac.kr.academicinformationsystem.domain.Course;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CourseRepository{

    private final EntityManager em;

    // 모든 Course정보 조회
    public List<Course> getAllCourses(){
        // 모든 Course정보 얻기
        return em.createQuery("select c from Course c", Course.class)
                .getResultList(); // List 형식으로 데이터 얻기
    }

    // 특정 학년 & 학기 정보에 해당하는 Course 정보 조회
    public List<Course> getSpecificCourses(int year, int semester){
        return em.createQuery(
                "select c from Course c where c.year = :year and c.semester = :semester",Course.class)
                .getResultList();
    }


}
