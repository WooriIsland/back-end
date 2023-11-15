package com.blacky.our_island.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
@Tag(name = "통신 테스트", description = "간단한 통신 테스트 API Document")
public class TestController {

    private final TestService testService;

//    @Autowired
//    public TestController(TestService testService) {
//        this.testService = testService;
//    }

    @GetMapping("/user")
    @Operation(summary = "GET 요청", description = "GET 요청입니다.")
    public String test() {

        return "테스트 성공";
    }

    @PostMapping("/sign-up")
    @Operation(summary = "POST 요청", description = "POST 요청입니다.")
    public String test2(@RequestBody TestDTO testDTO) {

        System.out.println("요청 값" + testDTO);

        testService.creatUser();

        return "회원가입 완료";

    }

}
