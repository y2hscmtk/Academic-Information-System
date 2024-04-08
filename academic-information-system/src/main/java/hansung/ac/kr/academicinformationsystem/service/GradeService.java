package hansung.ac.kr.academicinformationsystem.service;

import hansung.ac.kr.academicinformationsystem.dao.CourseDAO;
import hansung.ac.kr.academicinformationsystem.domain.Course;
import hansung.ac.kr.academicinformationsystem.repsitory.CourseRepository;
import lombok.RequiredArgsConstructor;;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final CourseRepository courseRepository;

    // 1. 수업데이터 바탕으로 총계 계산(가장 마지막 행에 취득학점 총계 표시)
    public CourseDAO getAllCoursesAndTotalScore() {
        List<Course> allCourses = courseRepository.getAllCourses();
        CourseDAO courseDAO = new CourseDAO();

        // 년도 - 학기를 키로 갖는 맵 생성
        Map<String, Integer> gradesByYearAndSemester = new HashMap<>();

        // 년도, 학기, 취득 학점
        for (Course course : allCourses) {
            String key = course.getYear() + "-" + course.getSemester();
            // 이미 존재한다면 누적
            gradesByYearAndSemester.merge(key, course.getGrades(), Integer::sum);
        }

        gradesByYearAndSemester.forEach((yearSemester, grades) -> {
            String[] parts = yearSemester.split("-");
            int year = Integer.parseInt(parts[0]);
            int semester = Integer.parseInt(parts[1]);
            courseDAO.addCourseData(new CourseDAO.CourseData(year, semester, grades));
        });

        // 총 취득 학점 계산
        int totalGrades = gradesByYearAndSemester.values().stream().mapToInt(Integer::intValue).sum();
        courseDAO.setTotalGrades(totalGrades); // 누적 합계 설정

        return courseDAO;
    }



    // 2. 특정 학기와 년도에 해당하는 수업 데이터 얻어오기
    public List<Course> getSpecificCourses(int year,int semester){
        return courseRepository.getSpecificCourses(year,semester);
    }



}
