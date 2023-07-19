package com.anrua.a1.product;

import java.util.List;

public interface ProductDao {
	void insert(ProductVO vo);
	void delete(ProductVO vo);

	ProductVO productedit(ProductVO vo);
	List<ProductVO> productlist(ProductVO vo);

}
