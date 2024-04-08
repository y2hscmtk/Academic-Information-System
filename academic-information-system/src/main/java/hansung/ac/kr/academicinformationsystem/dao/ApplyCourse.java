package hansung.ac.kr.academicinformationsystem.dao;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyCourse {
    @NotEmpty(message = "교과 코드를 작성해 주세요")
    @Pattern(regexp = "[a-zA-Z0-9]{7,}", message = "올바른 교과 코드 7자리를 입력해 주세요.")
    private String subject_code; // 교과코드 - 기본키

    // 2024 - 2 학기 수강신청 이므로
    private Integer year_of_attendance = 2024;
    private Integer semester = 2;

    @NotEmpty(message = "교과목 명을 작성해 주세요.")
    private String subject_name; // 교과목 명

    @NotEmpty(message = "교과 구분을 작성해 주세요.")
    private String subject_classification; // 교과 구분

    @NotEmpty(message = "담당 교수를 작성해 주세요.")
    private String professor_in_charge; // 담당 교수

    @NotNull(message = "수강 학점을 학점을 작성해 주세요.")
    private Integer grades; // 학점 - Integer로 변경
}
