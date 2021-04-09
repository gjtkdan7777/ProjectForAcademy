package com.hsm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.util.UserDAO;
import com.hsm.vo.AllBusVO;
import com.hsm.vo.BusTimeVO;
import com.hsm.vo.QnAVO;
import com.hsm.vo.TicketingVO;
import com.hsm.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO dao;
	
	@Override
	public int userJoin(UserVO vo) {
		
		return dao.userJoin(vo);
	}
	public UserVO selectOne(UserVO vo) {
		return dao.selectOne(vo);
	}
	public List<AllBusVO> busList(){
		return dao.busList();
	}
	public List<QnAVO> qnaList(){
		return dao.qnaList();
	}
	public List<AllBusVO> areaBusList(AllBusVO vo){
		return dao.areaBusList(vo);
	}
	public List<BusTimeVO> busTimeList(AllBusVO vo){
		return dao.busTimeList(vo);
	}
	public List<BusTimeVO> busSeat(BusTimeVO vo){
		return dao.busSeat(vo);
	}
	public BusTimeVO busChoose(BusTimeVO vo){
		return dao.busChoose(vo);
	}
	public int changePassword(UserVO vo){
		return dao.changePassword(vo);
	}
	public int changePhone(UserVO vo){
		return dao.changePhone(vo);
	}
	public int secession(UserVO vo){
		return dao.secession(vo);
	}
	public int qnaDelete(UserVO vo){
		return dao.qnaDelete(vo);
	}
	public int userContentInsert(QnAVO vo){
		return dao.userContentInsert(vo);
	}
	
}
