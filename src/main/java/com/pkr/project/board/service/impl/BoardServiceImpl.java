package com.pkr.project.board.service.impl;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.pkr.project.board.mapper.BoardMapper;
import com.pkr.project.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

	@Override
	public List<Map<String, Object>> selectBoard(Map<String, Object> paramMap) {
		JSONObject jsonObject = new JSONObject(paramMap);
		List<Map<String, Object>> result = boardMapper.selectBoard(paramMap);
		return result;
	}

	@Override
	public Map<String, Object> selectBoardDetail(int idx) {
		Map<String, Object> result = boardMapper.selectBoardDetail(idx);
		return result;
	}

	@Override
	public int insertBoard(Map<String, Object> paramMap) {
		int result = boardMapper.insertBoard(paramMap);
		return result;
	}

	@Override
	public int deleteBoard(int idx) {
		int result = boardMapper.deleteBoard(idx);
		return result;
	}

	@Override
	public int updateBoard(Map<String, Object> paramMap) {
		int result = boardMapper.updateBoard(paramMap);
		return result;
	}

}
