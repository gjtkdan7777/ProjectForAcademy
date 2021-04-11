package com.hsm.vo;

import lombok.Data;

@Data
public class TicketingVO {
	private int ticketing_number;
	private String email;
	private String departure_area; // 출발지
	private String destination;	   // 도착지
	private int number_of_tickets; // 티겟 매수
	private String seat_number;	   // 좌석
	private String departure_date; // 출발날짜
	private int ticketing_status;  // 좌석상태
	private String bus_name;	   // bus_name
	private String area_name;	   // ??
	private String[] seatNumbers;
	private int remaining_seats; 
}
 