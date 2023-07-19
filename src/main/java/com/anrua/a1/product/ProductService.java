package com.anrua.a1.product;

import java.util.List;

public interface ProductService {
	void insert(ProductVO vo);
	ProductVO productedit(ProductVO vo);
	void delete(ProductVO vo);
	List<ProductVO> productlist(ProductVO vo);
}
