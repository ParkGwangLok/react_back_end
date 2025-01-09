package com.pkr.project.notice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController {

	@GetMapping("/getTest")
	public ResponseEntity<String> getTest() {
		System.out.println("UserController checkIdDuplicate " + new Date());
        String message = "Hello, World!";
        return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello, World!";
    }
}


