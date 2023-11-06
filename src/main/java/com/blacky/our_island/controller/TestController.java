package com.blacky.our_island.controller;

import com.blacky.our_island.dto.TestDTO;
import com.blacky.our_island.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

//    @Autowired
//    public TestController(TestService testService) {
//        this.testService = testService;
//    }

    @GetMapping("/user")
    public String test() {

        return "테스트 성공";
    }

    @PostMapping("/sign-up")
    public String test2(@RequestBody TestDTO testDTO) {

        System.out.println("요청 값" + testDTO);

        testService.creatUser();

        return "회원가입 완료";

    }

}
