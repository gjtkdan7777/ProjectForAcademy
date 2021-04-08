package com.hsm.service;

import java.util.List;

import com.hsm.vo.Search;
import com.hsm.vo.SeatVO;
import com.hsm.vo.UserVO;

public interface AdminService {
	
	public List<Search> userList(Search vo);
	public int deleteUser(UserVO vo);
}
