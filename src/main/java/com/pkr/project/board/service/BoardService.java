package com.pkr.project.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
    List<Map<String, Object>> selectBoard(Map<String, Object> paramMap);

}
