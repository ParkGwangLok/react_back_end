package com.pkr.project.board.dto;

import lombok.Builder;

@Builder
public class BoardDto {
    private String contents;
    private int idx;
    private String title;
}
