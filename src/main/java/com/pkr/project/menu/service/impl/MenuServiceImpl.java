package com.pkr.project.menu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pkr.project.menu.mapper.MenuMapper;
import com.pkr.project.menu.service.MenuService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {
    private final MenuMapper menuMapper;

	@Override
	public List<Map<String, Object>> selectMenu() {
		return menuMapper.selectMenu();
	}

}
