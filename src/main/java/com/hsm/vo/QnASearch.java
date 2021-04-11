package com.hsm.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class QnASearch extends QnAVO {

	@Setter
	@Getter
	private String searchType;
	

	@Setter
	@Getter
	private String searchValue;
	
}
