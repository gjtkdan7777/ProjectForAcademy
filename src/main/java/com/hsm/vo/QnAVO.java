package com.hsm.vo;

import lombok.Data;

@Data
public class QnAVO {
	private int seq;
	private String email;
	private String content;
	private String registration_date;
	private String answer_content;
	private String answer_date;

}
