package com.hsm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.util.AdminDAO;
import com.hsm.vo.Search;
import com.hsm.vo.UserVO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDAO dao;
	
	public List<Search> userList(Search vo){
		return dao.userList(vo);
	}
	
	public int deleteUser(UserVO vo) {
		return dao.deleteUser(vo);
	}

}
