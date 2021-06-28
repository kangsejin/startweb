package com.example.startweb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	@Autowired
	public TestMapper mapper;
	
	public List<TestVo> selectTest() {
		return mapper.selectTest();
	}
	
}
