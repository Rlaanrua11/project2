package com.anrua.a1.cart;

import java.util.Date;

import lombok.Data;

@Data
public class OrderoneVO {
	private int baesongbi;
	private int totalmoney;
	private Date getdate;
	private int idx;
	private int pid;
	private String phone;
	private String address;
	private String pname;
	private String cname;
	private int orderg;
}
