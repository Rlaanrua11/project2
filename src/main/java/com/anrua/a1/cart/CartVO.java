package com.anrua.a1.cart;

import lombok.Data;

@Data
public class CartVO {
	private int cid;
	private int pid;
	private int custno;
	private int amount;
	
	private String pprice;
	private String pname;
	private String pimgstr;
	
}
