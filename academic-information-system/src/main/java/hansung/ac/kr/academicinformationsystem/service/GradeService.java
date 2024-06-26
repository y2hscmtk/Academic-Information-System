package hansung.ac.kr.academicinformationsystem.service;

import hansung.ac.kr.academicinformationsystem.dao.ApplyCourse;
import hansung.ac.kr.academicinformationsystem.dto.CourseDTO;
import hansung.ac.kr.academicinformationsystem.domain.Course;
import hansung.ac.kr.academicinformationsystem.repsitory.CourseRepository;
import lombok.RequiredArgsConstructor;;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final CourseRepository courseRepository;

    // 1. 수업데이터 바탕으로 총계 계산(가장 마지막 행에 취득학점 총계 표시)
    public CourseDTO getAllCoursesAndTotalScore() {
        List<Course> allCourses = courseRepository.getAllCourses();
        CourseDTO courseDTO = new CourseDTO();

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
            courseDTO.addCourseData(new CourseDTO.CourseData(year, semester, grades));
        });

        // 총 취득 학점 계산
        int totalGrades = gradesByYearAndSemester.values().stream().mapToInt(Integer::intValue).sum();
        courseDTO.setTotalGrades(totalGrades); // 누적 합계 설정
        courseDTO.sortCourseDataByYear(); // 정렬 로직 수행
        return courseDTO;
    }



    // 2. 특정 학기와 년도에 해당하는 수업 데이터 얻어오기
    public List<Course> getSpecificCourses(int year,int semester){
        return courseRepository.getSpecificCourses(year,semester);
    }

    // 3. 수강신청
    public void applyCourse(ApplyCourse applyCourse) {
        // ApplyCourse -> Course 변환 필요
        Course course = Course.builder().name(applyCourse.getSubjectName())
                .year(applyCourse.getYear())
                .code(applyCourse.getSubjectCode())
                .grades(applyCourse.getGrades())
                .classification(applyCourse.getClassification())
                .professor(applyCourse.getProfessor())
                .semester(applyCourse.getSemester())
                .build();

        courseRepository.save(course);
    }


}
