package com.anrua.a1.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao dao;
	@Override
	public void insert(CartVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public List<CartVO> cartlist(CartVO vo) {
		// TODO Auto-generated method stub
		return dao.cartlist(vo);
	}

	@Override
	public void deleteone(CartVO vo) {
		dao.deleteone(vo);
		
	}

	@Override
	public void deleteall(CartVO vo) {
		dao.deleteall(vo);
	}

	@Override
	public List<OrdermVO> orderlist(OrdermVO vo) {
		// TODO Auto-generated method stub
		return dao.orderlist(vo);
	}

	@Override
	public void insertorder(OrderjVO vo) {
		dao.insertorder(vo);
		
	}

	@Override
	public void insertmoney(OrdermVO vo) {
		dao.insertmoney(vo);
		
	}

	@Override
	public void update(CartVO vo) {
		dao.update(vo);
		
	}

	@Override
	public OrdermVO orderg(OrdermVO vo) {
		// TODO Auto-generated method stub
		return dao.orderg(vo);
	}

}
