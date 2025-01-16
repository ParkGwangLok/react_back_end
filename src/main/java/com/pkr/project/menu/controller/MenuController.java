package com.pkr.project.menu.controller;

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
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/selectMenu")
    public ResponseEntity<List<Map<String, Object>>> selectMenu() {
    	List<Map<String, Object>> result = menuService.selectMenu();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}