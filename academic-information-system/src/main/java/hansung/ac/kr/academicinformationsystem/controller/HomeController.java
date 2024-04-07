package hansung.ac.kr.academicinformationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 메인 화면 => 누구나 접근 가능
    // <제공 화면>
    // 수강 신청 / 수강 신청 조회 / 이수 학점 조회
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
