package hansung.ac.kr.academicinformationsystem.service;

import hansung.ac.kr.academicinformationsystem.dao.CourseDAO;
import hansung.ac.kr.academicinformationsystem.domain.Course;
import hansung.ac.kr.academicinformationsystem.repsitory.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GradeService {

    private final CourseRepository courseRepository;

    // 1. 수업데이터 바탕으로 총계 계산(가장 마지막 행에 취득학점 총계 표시)
    public CourseDAO getAllCoursesAndTotalScore() {
        List<Course> allCourses = courseRepository.getAllCourses();
        // 필요한 데이터 => 데이터 가공 필요
        CourseDAO courseDAO = new CourseDAO();
        int totalGrades = 0;
        // 년도, 학기, 취득 학점
        for (Course course : allCourses) {
            CourseDAO.CourseData courseData = new CourseDAO.CourseData(course.getYear(), course.getSemester(), course.getGrades());
            courseDAO.addCourseData(courseData); // 정보 추가
            totalGrades += course.getGrades();
        }
        courseDAO.setTotalGrades(totalGrades); // 누적 합계
        return courseDAO;
    }


    // 2. 특정 학기와 년도에 해당하는 수업 데이터 얻어오기
    public List<Course> getSpecificCourses(int year,int semester){
        return courseRepository.getSpecificCourses(year,semester);
    }



}
