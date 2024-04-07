package hansung.ac.kr.academicinformationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 학사정보 컨트롤러
@Controller
public class GradeController {
    // 3) 학사 정보 접근시 인증 유무를 체크한다. 인증된 경우, 아래 4)번 작업을 수행하고
    // 미인증시 인증을 위한 Custom 로그인 폼(username, password)을 디스플레이한다. => 스프링 Security 사용
    // 이 때 로그인 폼은 스프링에서 제공하는 UI (User Interface)가 아니라 자체적으로 작성한다.

    // 4) ① '학년별 이수 학점 조회' 시 학기별 이수 총 학점을 보여준다. 이 때 반드시 총계도 표시한다.
    // 년도, 학기, 취득 학점, 상세보기(링크)
    // 총계,      총 취득 학점
    @GetMapping("/total-grade")
    public String totalGrade(Model model) {
        return "totalGrade";
    }

    // 특정 년도-학기에 해당하는 테이블 조회
    // 년도, 학기, 교과목 명, 교과 구분, 담당 교수, 학점
    @GetMapping("/grade-detail")
    public String gradeDetail(
            @RequestParam String year, // 년도
            @RequestParam String semester, // 학기
            Model model) {
        // 년도와 학기 정보를 바탕으로 테이블 생성
        return "gradeDetail";
    }
}
