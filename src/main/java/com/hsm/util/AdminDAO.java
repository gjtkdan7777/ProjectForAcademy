package com.hsm.util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsm.vo.QnAVO;
import com.hsm.vo.Search;
import com.hsm.vo.TicketingVO;
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
	public int deleteQuestion(QnAVO vo) {
		return sqlSession.delete(NS+"deleteQuestion",vo);
	}
	public UserVO selectOne(UserVO vo) {
		return sqlSession.selectOne(NS+"selectOne",vo);
	}
	public int update(UserVO vo) {
		return sqlSession.update(NS+"update",vo);
	}
	public int insertAnswer(QnAVO vo) {
		return sqlSession.update(NS+"insertAnswer",vo);
	}
	public List<QnAVO> qnaList() {
		return sqlSession.selectList(NS+"qnaList");
	}
	public List<TicketingVO> TicketingList() {
		return sqlSession.selectList(NS+"TicketingList");
	}
	public QnAVO selectQnA(QnAVO vo) {
		return sqlSession.selectOne(NS+"selectQnA",vo);
	}
}
