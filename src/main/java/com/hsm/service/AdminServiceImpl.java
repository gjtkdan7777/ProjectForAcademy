package com.hsm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.util.AdminDAO;
import com.hsm.vo.QnASearch;
import com.hsm.vo.QnAVO;
import com.hsm.vo.Search;
import com.hsm.vo.TicketingVO;
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
	public int deleteQuestion(QnAVO vo) {
		return dao.deleteQuestion(vo);
	}
	
	public UserVO selectOne(UserVO vo) {
		return dao.selectOne(vo);
	}
	public int update(UserVO vo) {
		return dao.update(vo);
	}
	public List<QnASearch> qnaList(QnASearch vo){
		return dao.qnaList(vo);
	}
	public QnAVO selectQnA(QnAVO vo) {
		return dao.selectQnA(vo);
	}
	public int insertAnswer(QnAVO vo) {
		return dao.insertAnswer(vo);
		
	}
	public List<TicketingVO> TicketingList() {
		return dao.TicketingList();
	}
}
