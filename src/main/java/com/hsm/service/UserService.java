package com.hsm.service;

import java.util.List;

import com.hsm.vo.AllBusVO;
import com.hsm.vo.BusTimeVO;
import com.hsm.vo.QnAVO;
import com.hsm.vo.TicketingVO;
import com.hsm.vo.UserVO;

public interface UserService {
	public int userJoin(UserVO vo);
	public UserVO selectOne(UserVO vo);
	public List<AllBusVO> busList();
	public List<QnAVO> qnaList();
	public List<AllBusVO> areaBusList(AllBusVO vo);
	public List<BusTimeVO> busTimeList(AllBusVO vo);
	public List<BusTimeVO> busSeat(BusTimeVO vo);
	public BusTimeVO busChoose(BusTimeVO vo);
	public int changePassword(UserVO vo);
	public int changePhone(UserVO vo);
	public int secession(UserVO vo);
	public int qnaDelete(UserVO vo);
	public int userContentInsert(QnAVO vo);
	
}
