package com.anrua.a1.guestbook;

import java.util.Date;

import lombok.Data;

@Data
public class GuestVO {
	private  int  rownum;
	private  int  rnum;
	private  int  idx;
	private  String title;
	private  String writer;
	private  Date  datestr;
}
