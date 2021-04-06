package com.hsm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsm.util.UserDAO;
import com.hsm.vo.AllBusVO;
import com.hsm.vo.BusTimeVO;
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
	public List<AllBusVO> busList(AllBusVO vo){
		return dao.busList(vo);
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
}
