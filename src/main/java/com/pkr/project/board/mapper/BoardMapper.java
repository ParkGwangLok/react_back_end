package com.pkr.project.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	List<Map<String, Object>> selectBoard(Map<String, Object> paramMap);
	Map<String, Object> selectBoardDetail(int idx);
	int insertBoard(Map<String, Object> paramMap);
	int deleteBoard(int idx);
	int updateBoard(Map<String, Object> paramMap);
}
