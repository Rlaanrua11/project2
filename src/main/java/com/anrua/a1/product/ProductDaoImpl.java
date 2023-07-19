package com.anrua.a1.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insert(ProductVO vo) {
		mybatis.insert("product.INSERT",vo);
		
	}

	@Override
	public List<ProductVO> productlist(ProductVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("product.SELECT_ALL");
	}

	@Override
	public ProductVO productedit(ProductVO vo) {
		return mybatis.selectOne("product.SELECT_ONE",vo);
		
	}

	@Override
	public void delete(ProductVO vo) {
		mybatis.delete("product.DELETE",vo);
	}



}
