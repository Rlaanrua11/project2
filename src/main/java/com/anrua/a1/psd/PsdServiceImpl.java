package com.anrua.a1.psd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsdServiceImpl implements PsdService{
	@Autowired
	private PsdDao dao;
	
	@Override
	public void insert(PsdVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public PsdVO custno(PsdVO vo) {
		// TODO Auto-generated method stub
		return dao.custno(vo);
	}

	@Override
	public List<PsdVO> getpsdlist(PsdVO vo) {
		// TODO Auto-generated method stub
		return dao.getpsdlist(vo);
	}

	@Override
	public PsdVO edit(PsdVO vo) {
		return dao.edit(vo);
	}

	@Override
	public void update(PsdVO vo) {
		dao.update(vo);
		
	}

	@Override
	public void delete(PsdVO vo) {
		dao.delete(vo);
		
	}

	@Override
	public List<PsdVO> shoplist(PsdVO vo) {
		// TODO Auto-generated method stub
		return dao.shoplist(vo);
	}

	@Override
	public String idc(PsdVO vo) {
		// TODO Auto-generated method stub
		return dao.idc(vo);
	}

	@Override
	public void shopinsert(PsdVO vo) {
		// TODO Auto-generated method stub
		dao.shopinsert(vo);
	}

}
