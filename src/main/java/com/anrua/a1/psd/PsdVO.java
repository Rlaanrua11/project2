package com.anrua.a1.psd;

import java.util.Date;

import lombok.Data;

@Data
public class PsdVO {
	private String ch1;
	private String ch2;
	private int custno;
	private String custname;
	private String phone;
	
	private String addresscode;
	private String address;
	private String address2;
	
	private String joindatestr;
	private Date joindate;
	private String grade;
	private String city;
	
	private int salenol;
	private int pcost;
	private int amount;
	private int price;
	private String sdatestr;
	private Date sdate;
	
	private String id;
	private String password;
}
