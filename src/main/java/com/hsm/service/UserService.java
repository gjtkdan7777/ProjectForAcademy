package com.hsm.service;

import java.util.List;

import com.hsm.vo.AllBusVO;
import com.hsm.vo.BusTimeVO;
import com.hsm.vo.QnAVO;
import com.hsm.vo.SeatVO;
import com.hsm.vo.TicketingVO;
import com.hsm.vo.UserVO;

public interface UserService {
	public int userJoin(UserVO vo);
	public UserVO selectOne(UserVO vo);
	public List<AllBusVO> busList();
	public List<QnAVO> qnaList();
	public List<AllBusVO> areaBusList(AllBusVO vo);
	public List<BusTimeVO> busTimeList(AllBusVO vo);
	public List<SeatVO> busSeat(BusTimeVO vo);
	public BusTimeVO busChoose(BusTimeVO vo);
	public int changePassword(UserVO vo);
	public int changePhone(UserVO vo);
	public int secession(UserVO vo);
	public int qnaDelete(UserVO vo);
	public int userContentInsert(QnAVO vo);
	public int buyTicket(TicketingVO vo);
	public List<TicketingVO> ticketList(UserVO vo);
	public int busSeatcount(TicketingVO vo);
	public int seatUpdate(TicketingVO vo);
	public int pay(UserVO vo);
	public int addSeat(BusTimeVO vo);
	public int cancelTicket(TicketingVO vo);
	public TicketingVO getTicket(TicketingVO vo);
	public int seatCancel(TicketingVO vo);
	public int payCancel(UserVO vo);
	public int myticketList(UserVO vo);
	public UserVO findPW(UserVO vo);
	
}
