package com.anrua.a1.cart;

import java.util.Date;

import lombok.Data;

@Data
public class OrderjVO {	
 private int    idx  ;
 private int    custno  ;
 private int 	cid   ;
 private int 	pid  ;
 private String	pname  ;
 private int 	amount  ;
 private Date   getdate   ;
 
 private int 	orderg;
}
