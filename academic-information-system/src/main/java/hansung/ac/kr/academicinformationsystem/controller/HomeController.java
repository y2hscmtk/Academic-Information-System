package hansung.ac.kr.academicinformationsystem.controller;

import hansung.ac.kr.academicinformationsystem.domain.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

// 2) 학사 정보 시스템에 대한 홈페이지를 작성한다. 학사 정보 접근 메뉴는
// ① 학년별 이수 학점 조회,
// ② 수강 신청하기,
// ③ 수강 신청 조회가 있다. 이 때 홈페이지는 누구나 접근 가능하며,학사 정보 접근은 반드시 로그인을 수행한 후, 접근할 수 있다.
@Controller
public class HomeController {

    // 메인 화면 => 누구나 접근 가능
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
