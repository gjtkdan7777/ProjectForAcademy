package com.hsm.util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsm.vo.AllBusVO;
import com.hsm.vo.BusTimeVO;
import com.hsm.vo.QnAVO;
import com.hsm.vo.SeatVO;
import com.hsm.vo.TicketingVO;
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
	public List<AllBusVO> busList() {
		return sqlSession.selectList(NS+"busList");
	}
	public List<QnAVO> qnaList() {
		return sqlSession.selectList(NS+"qnaList");
	}
	public List<AllBusVO> areaBusList(AllBusVO vo) {
		return sqlSession.selectList(NS+"areaBusList",vo);
	}
	public List<BusTimeVO> busTimeList(AllBusVO vo) {
		return sqlSession.selectList(NS+"busTimeList",vo);
	}
	public List<SeatVO> busSeat(BusTimeVO vo) {
		return sqlSession.selectList(NS+"busSeat",vo);
	}
	public List<TicketingVO> ticketList(UserVO vo) {
		return sqlSession.selectList(NS+"ticketList",vo);
	}
	public BusTimeVO busChoose(BusTimeVO vo) {
		return sqlSession.selectOne(NS+"busChoose",vo);
	}
	public TicketingVO getTicket(TicketingVO vo) {
		return sqlSession.selectOne(NS+"getTicket",vo);
	}
	public int changePassword(UserVO vo) {
		return sqlSession.update(NS+"changePassword",vo);
	}
	public int changePhone(UserVO vo) {
		return sqlSession.update(NS+"changePhone",vo);
	}
	public int secession(UserVO vo) {
		return sqlSession.delete(NS+"secession",vo);
	}
	public int qnaDelete(UserVO vo) {
		return sqlSession.delete(NS+"qnaDelete",vo);
	}
	public int userContentInsert(QnAVO vo) {
		return sqlSession.insert(NS+"userContentInsert",vo);
	}
	public int buyTicket(TicketingVO vo) {
		return sqlSession.insert(NS+"buyTicket",vo);
	}
	public int busSeatcount(TicketingVO vo) {
		return sqlSession.selectOne(NS+"busSeatcount",vo);
	}
	public int seatUpdate(TicketingVO vo) {
		return sqlSession.update(NS+"seatUpdate",vo);
	}
	public int pay(UserVO vo) {
		return sqlSession.update(NS+"pay",vo);
	}
	public int addSeat(BusTimeVO vo) {
		return sqlSession.update(NS+"addSeat",vo);
	}
	public int cancelTicket(TicketingVO vo) {
		return sqlSession.update(NS+"cancelTicket",vo);
	}
	public int seatCancel(TicketingVO vo) {
		return sqlSession.update(NS+"seatCancel",vo);
	}
	public int payCancel(UserVO vo) {
		return sqlSession.update(NS+"payCancel",vo);
	}
	
	
}
