package com.anrua.a1.cart;

import java.util.Date;

import lombok.Data;

@Data
public class OrdermVO {
  private int    idx  ;
  private int    ocustno  ;
  private int 	 baesongbi   ;
  private int 	 totalmoney  ;
  private Date   getdate   ;
}
