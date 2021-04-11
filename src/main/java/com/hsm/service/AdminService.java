package com.hsm.service;

import java.util.List;

import com.hsm.vo.QnASearch;
import com.hsm.vo.QnAVO;
import com.hsm.vo.Search;
import com.hsm.vo.TicketingVO;
import com.hsm.vo.UserVO;

public interface AdminService {
	
	public List<Search> userList(Search vo);
	public int deleteUser(UserVO vo);
	public UserVO selectOne(UserVO vo);
	public int update(UserVO vo);
	public List<QnASearch> qnaList(QnASearch vo);
	public QnAVO selectQnA(QnAVO vo);
	public int insertAnswer(QnAVO vo);
	public int deleteQuestion(QnAVO vo);
	public List<TicketingVO> TicketingList();
}
