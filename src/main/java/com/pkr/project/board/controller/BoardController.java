package com.pkr.project.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pkr.project.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/selectBoard")
    public ResponseEntity<List<Map<String, Object>>> selectBoard(@RequestBody(required = true) Map<String, Object> paramMap) {
    	List<Map<String, Object>> result = boardService.selectBoard(paramMap);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @GetMapping("/{idx}")
    public ResponseEntity<Map<String, Object>> selectBoardDetail(@PathVariable int idx) {
    	Map<String, Object> result = boardService.selectBoardDetail(idx);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @PostMapping("/insertBoard")
    public ResponseEntity<?> insertBoard(@RequestBody(required = true) Map<String, Object> paramMap) {
    	int result = boardService.insertBoard(paramMap);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @PostMapping("/updateBoard")
    public ResponseEntity<?> updateBoard(@RequestBody(required = true) Map<String, Object> paramMap) {
    	int result = boardService.updateBoard(paramMap);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/deleteBoard/{idx}")
    public ResponseEntity<?> deleteBoard(@PathVariable int idx) {
    	int result = boardService.deleteBoard(idx);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
}