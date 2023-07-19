package com.anrua.a1.cart;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insert(CartVO vo) {
		mybatis.insert("cart.INSERT",vo);
		
	}

	@Override
	public List<CartVO> cartlist(CartVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("cart.SELECT_ALL",vo);
	}

	@Override
	public void deleteone(CartVO vo) {
		mybatis.delete("cart.DELETE_ONE",vo);
		
	}

	@Override
	public void deleteall(CartVO vo) {
		mybatis.delete("cart.DELETE_ALL",vo);
		
	}

	@Override
	public List<OrdermVO> orderlist(OrdermVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("order.SELECT_ORDER_ALL",vo);
	}

	@Override
	public void insertorder(OrderjVO vo) {
		mybatis.insert("order.INSERT_JUMUN",vo);
		
	}

	@Override
	public void insertmoney(OrdermVO vo) {
		mybatis.insert("order.INSERT_MONEY",vo);
	}

	@Override
	public void update(CartVO vo) {
		mybatis.update("cart.UPDATE",vo);
	}

	@Override
	public OrdermVO orderg(OrdermVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("order.SELECT_ORDER",vo);
	}

}
