package com.gsmhrm.anything_back.domain.kakao.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gsmhrm.anything_back.domain.auth.service.MemberLogoutService;
import com.gsmhrm.anything_back.domain.kakao.presentation.dto.KakaoUserInfo;
import com.gsmhrm.anything_back.domain.kakao.service.KakaoUserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OAuthController {

    private final KakaoUserService kakaoUserService;

    private final MemberLogoutService memberLogoutService;

    @RequestMapping("/oauth2/kakao")
    @ResponseBody
    @GetMapping
    public KakaoUserInfo handleKakao(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        return kakaoUserService.kakaoLogin(code, response);
    }

    @RequestMapping("/ouath2/logout")
    @DeleteMapping
    public ResponseEntity<Void> kakaoLogout(@RequestHeader("Authorization") String accessToken) {
        memberLogoutService.execute(accessToken);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
