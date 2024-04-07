package hansung.ac.kr.academicinformationsystem.controller;

import hansung.ac.kr.academicinformationsystem.domain.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

// 학사정보 컨트롤러
@Controller
public class GradeController {
    // 3) 학사 정보 접근시 인증 유무를 체크한다. 인증된 경우, 아래 4)번 작업을 수행하고
    // 미인증시 인증을 위한 Custom 로그인 폼(username, password)을 디스플레이한다. => 스프링 Security 사용
    // 이 때 로그인 폼은 스프링에서 제공하는 UI (User Interface)가 아니라 자체적으로 작성한다.

    // 4) ① '학년별 이수 학점 조회' 시 학기별 이수 총 학점을 보여준다. 이 때 반드시 총계도 표시한다.
    // 교과코드, 수강년도, 학기, 교과목명, 교과구분, 담당교수, 학점.. (가장 마지막 행에 취득학점 총계 표시)
    // 학년별 이수 학점 조회 페이지로 이동
    @GetMapping("/total-grade")
    public String totalGrade(Model model) {
        ArrayList<Course> totalGradeList = new ArrayList<>();
        model.addAttribute("totalGradeList","dfd");
        return "totalGrade";
    }
}
