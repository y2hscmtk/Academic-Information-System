package hansung.ac.kr.academicinformationsystem.controller;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 수강신청 컨트롤러
// - 신청 => 검증 필요(이미 수강신청 되어있는지, 유효한 형식인지(어노테이션 검사))
// - 조회 => 조건 검색
@Controller
@NoArgsConstructor
public class CourseController {

    // ② ‘수강 신청하기’ 메뉴 선택시, 2024년 2학기에 신청할 교과목을 웹 폼을 통해 입력 받은후DB에 저장한다.
    // 이 때 사용자가 입력한 데이터에 대한 오류 검증 작업을 반드시 실시하고 수강 신청 교과목을 DB에 저장한다.
    // 수강 신청하기 페이지로 이동
    @GetMapping("/apply-course")
    public String enrolment(){ // 수강신청 폼 전달 필요
        return "applyCourse"; // 수강신청 페이지 연결
    }

    // ③ ‘수강 신청 조회” 메뉴를 통해 2024 년 2 학기 수강 신청 내역을 디스플레이한다
    // 수강 신청 조회 페이지로 이동
    @GetMapping("/my-course")
    public String enrolmentLookUp() {
        // 2024-2학기 수강 신청 내역 Service에게 요청
        return "myCourse";
    }
}
