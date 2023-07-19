package com.anrua.a1.openApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyDao dao;
	
	@Override
	public void insert(CompanyVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public List<CompanyVO> list(CompanyVO vo) {
		// TODO Auto-generated method stub
		return dao.list(vo);
	}

	@Override
	public CompanyVO edit(CompanyVO vo) {
		// TODO Auto-generated method stub
		return dao.edit(vo);
	}

	@Override
	public void evinsert(EvSearchVO vo) {
		dao.evinsert(vo);
		
	}

	@Override
	public List<EvSearchVO> evlist(EvSearchVO vo) {
		// TODO Auto-generated method stub
		return dao.evlist(vo);
	}

	@Override
	public EvSearchVO evedit(EvSearchVO vo) {
		// TODO Auto-generated method stub
		return dao.evedit(vo);
	}

}
