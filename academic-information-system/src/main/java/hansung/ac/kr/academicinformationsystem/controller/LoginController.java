package hansung.ac.kr.academicinformationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 로그인과 관련된 로직 수행
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
