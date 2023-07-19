package com.anrua.a1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao dao;
	
	@Override
	public void insert(ProductVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public List<ProductVO> productlist(ProductVO vo) {
		// TODO Auto-generated method stub
		return dao.productlist(vo);
	}

	@Override
	public ProductVO productedit(ProductVO vo) {
		return dao.productedit(vo);
		
	}

	@Override
	public void delete(ProductVO vo) {
		dao.delete(vo);
	}

}
