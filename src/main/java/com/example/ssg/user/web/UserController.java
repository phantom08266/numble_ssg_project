package com.example.ssg.user.web;

import com.example.ssg.user.service.UserService;
import com.example.ssg.user.web.dto.UserCheckResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/login.do")
    public String login() {

        return "user/login";
    }

    @GetMapping("/user/signup.do")
    public String signUp() {

        return "user/signup";
    }

    @GetMapping("/user/idCheck")
    @ResponseBody
    public ResponseEntity<?> checkUserId(@RequestParam("id") String userId) {
        boolean result = userService.isUserIdExist(userId);
        return ResponseEntity.ok(UserCheckResultResponse.builder()
            .result(result)
            .build());
    }

}
