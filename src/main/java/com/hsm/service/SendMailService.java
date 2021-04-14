package com.hsm.service;

import com.hsm.vo.UserVO;

public interface SendMailService {
	public boolean sendEmail(UserVO vo);
}
