package com.hsm.util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsm.vo.Search;
import com.hsm.vo.SeatVO;
import com.hsm.vo.UserVO;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "com.ncs.AdminMapper.";
	
	public List<Search> userList(Search vo) {
		return sqlSession.selectList(NS+"userList", vo);
	}
	
	public int deleteUser(UserVO vo) {
		return sqlSession.delete(NS+"deleteUser",vo);
	}

}
