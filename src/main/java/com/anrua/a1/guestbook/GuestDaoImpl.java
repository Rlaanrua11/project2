package com.anrua.a1.guestbook;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class GuestDaoImpl implements GuestDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void insert(GuestVO vo) {
		mybatis.insert("guest.INSERT",vo);
		
	}

	@Override
	public List<GuestVO> list(GuestVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("guest.SELECT_ALL",vo);
	}

	@Override
	public int count(GuestVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("guest.COUNT",vo);
	}

}
