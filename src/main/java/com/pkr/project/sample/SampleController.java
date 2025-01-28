package com.pkr.project.sample;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkr.project.menu.service.MenuService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {
    private final MenuService menuService;

    @GetMapping("/selectMenu")
    public ResponseEntity<List<Map<String, Object>>> selectMenu() {
    	
    	String userName = "박광록";
    
//    	String result1 = JwtUtil.generateToken(userName);
//    	Claims result2 = JwtUtil.extractClaims(result1);
//    	String result3 = JwtUtil.extractUsername(result1);
//    	boolean result4 = JwtUtil.validateToken(result1, userName);
    	
    	List<Map<String, Object>> result = menuService.selectMenu();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}