package com.hsm.vo;

import lombok.Data;

@Data
public class BusTimeVO {
	private String area;
	private String departure_time;
	private String destination;
	private int ticket_price;
	private int remaining_seats;
	private int total_seats;
	private String bus_name;
	
}
