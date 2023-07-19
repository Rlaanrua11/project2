package com.anrua.a1.cart;

import java.util.List;

public interface CartDao {
	void insert(CartVO vo);
	void deleteone(CartVO vo);
	void deleteall(CartVO vo);
	void update(CartVO vo);
	List<CartVO> cartlist(CartVO vo);

	void insertorder(OrderjVO vo);
	void insertmoney(OrdermVO vo);
	OrdermVO orderg(OrdermVO vo);
	List<OrdermVO> orderlist(OrdermVO vo);
}
