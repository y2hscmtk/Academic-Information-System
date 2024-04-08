package hansung.ac.kr.academicinformationsystem.dao;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ApplyCourse {
    @NotEmpty
    private String subject_code; // 교과코드 - 기본키

    @NotEmpty
    @Pattern(regexp = "\\d{4}", message = "4자리 년도를 모두 입력해주세요")
    private String year_of_attendance; // 수강년도 - 문자열로 변경 필요

    @NotNull
    @Min(value = 1,message = "1학기, 2학기 중에 선택해주세요.") @Max(value = 2,message = "1학기, 2학기 중에 선택해주세요.")
    private Integer semester; // 수강 학기 - Integer로 변경

    @NotEmpty
    private String subject_name; // 교과목 명

    @NotEmpty
    private String subject_classification; // 교과 구분

    @NotEmpty
    private String professor_in_charge; // 담당 교수

    @NotNull
    private Integer grades; // 학점 - Integer로 변경
}
