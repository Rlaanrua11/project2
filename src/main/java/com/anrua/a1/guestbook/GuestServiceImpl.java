package com.anrua.a1.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService{
	
	@Autowired
	private GuestDao dao;
	
	@Override
	public void insert(GuestVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public List<GuestVO> list(GuestVO vo) {
		// TODO Auto-generated method stub
		return dao.list(vo);
	}

	@Override
	public int count(GuestVO vo) {
		// TODO Auto-generated method stub
		return dao.count(vo);
	}

}
