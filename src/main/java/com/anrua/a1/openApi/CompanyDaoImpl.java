package com.anrua.a1.openApi;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl implements CompanyDao{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insert(CompanyVO vo) {
		mybatis.insert("company.INSERT",vo);
		
	}

	@Override
	public List<CompanyVO> list(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("company.SELECT_ALL",vo);
	}

	@Override
	public CompanyVO edit(CompanyVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("company.SELECT_ONE",vo);
	}

	@Override
	public void evinsert(EvSearchVO vo) {
		mybatis.insert("company.EVINSERT",vo);
		
	}

	@Override
	public List<EvSearchVO> evlist(EvSearchVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("company.EVSELECT_ALL",vo);
	}

	@Override
	public EvSearchVO evedit(EvSearchVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("company.SELECT_EVONE",vo);
	}

}
