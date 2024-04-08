package hansung.ac.kr.academicinformationsystem.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

// '학년별 이수 학점 조회' 시 사용하기 위함
@Getter @Setter
public class CourseDAO {
    @Getter @Setter @AllArgsConstructor
    public static class CourseData {
        private int year; //년도
        private int semester; //학기
        private int grades; //취득학점
    }

    private ArrayList<CourseData> courseDataArray = new ArrayList<>();
    private int totalGrades; // 총 취득학점

    public void addCourseData(CourseData courseData) {
        this.courseDataArray.add(courseData);
    }

}
