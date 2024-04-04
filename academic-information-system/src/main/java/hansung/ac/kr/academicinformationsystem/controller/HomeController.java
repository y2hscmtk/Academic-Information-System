package hansung.ac.kr.academicinformationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    // 3) 학사 정보 접근시 인증 유무를 체크한다. 인증된 경우, 아래 4)번 작업을 수행하고
    // 미인증시 인증을 위한 Custom 로그인 폼(username, password)을 디스플레이한다. => 스프링 Security 사용
    // 이 때 로그인 폼은 스프링에서 제공하는 UI (User Interface)가 아니라 자체적으로 작성한다.

    // 4) ① '학년별 이수 학점 조회' 시 학기별 이수 총 학점을 보여준다. 이 때 반드시 총계도 표시한다.
    // 교과코드, 수강년도, 학기, 교과목명, 교과구분, 담당교수, 학점.. (가장 마지막 행에 취득학점 총계 표시)
    // 학년별 이수 학점 조회 페이지로 이동
    @GetMapping("/total-grade")
    public String totalGrade() {
        return "totalGrade";
    }

    // ② ‘수강 신청하기’ 메뉴 선택시, 2024년 2학기에 신청할 교과목을 웹 폼을 통해 입력 받은후DB에 저장한다.
    // 이 때 사용자가 입력한 데이터에 대한 오류 검증 작업을 반드시 실시하고 수강 신청 교과목을 DB에 저장한다.

    // 수강 신청하기 페이지로 이동
    @GetMapping("/enrolment")
    public String enrolment(){
        return "enrolment";
    }

    // ③ ‘수강 신청 조회” 메뉴를 통해 2024 년 2 학기 수강 신청 내역을 디스플레이한다
    // 수강 신청 조회 페이지로 이동
    @GetMapping("/enrolment-look-up")
    public String enrolmentLookUp() {
        return "enrolmentLookUp";
    }
}
