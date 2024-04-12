package hansung.ac.kr.academicinformationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Comparator;

// '학년별 이수 학점 조회' 시 사용하기 위함
@Getter @Setter
public class CourseDTO {
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

    // 오름차순 정렬
    public void sortCourseDataByYear() {
        // 년도 - 학기 기준으로 정렬
        courseDataArray.sort(Comparator.comparingInt(CourseData::getYear).thenComparingInt(CourseData::getSemester));
    }

}
