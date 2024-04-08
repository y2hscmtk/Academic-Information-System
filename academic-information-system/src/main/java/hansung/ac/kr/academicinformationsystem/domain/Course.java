package hansung.ac.kr.academicinformationsystem.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "Course")
public class Course {
    @Id @Column(name = "subject_code")
    private String code; // 교과코드 - 기본키
    @Column(name = "year_of_attendance")
    private int year; // 수강년도
    @Column(name = "semester")
    private int semester; // 수강 학기
    @Column(name = "subject_name")
    private String name; // 교과목 명
    @Column(name = "subject_classification")
    private String classification; // 교과 구분
    @Column(name = "professor_in_charge")
    private String professor; // 담당 교수
    @Column(name = "grades")
    private int grades; // 학점
}
