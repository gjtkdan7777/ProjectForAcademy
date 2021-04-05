package com.hsm.vo;

import lombok.Data;

@Data
public class UserVO {
	private String email;
	private String password;
	private String phone;
	private String birthd;
	private int point;
	private String registration_date;
}
