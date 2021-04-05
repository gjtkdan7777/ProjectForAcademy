package com.hsm.util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsm.vo.AllBusVO;
import com.hsm.vo.BusTimeVO;
import com.hsm.vo.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "com.ncs.UserMapper.";
	
	public int userJoin(UserVO vo) {
		return sqlSession.insert(NS+"join",vo);
	}
	public UserVO selectOne(UserVO vo) {
		return sqlSession.selectOne(NS+"selectOne",vo);
	}
	public List<AllBusVO> busList(AllBusVO vo) {
		return sqlSession.selectList(NS+"busList",vo);
	}
	public List<BusTimeVO> busTimeList(AllBusVO vo) {
		return sqlSession.selectList(NS+"busTimeList",vo);
	}
	public List<BusTimeVO> busSeat(BusTimeVO vo) {
		return sqlSession.selectList(NS+"busSeat",vo);
	}
	public BusTimeVO busChoose(BusTimeVO vo) {
		return sqlSession.selectOne(NS+"busChoose",vo);
	}
}
