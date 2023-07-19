package com.anrua.a1.psd;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PsdDaoImpl implements PsdDao{
	@Autowired
	private SqlSessionTemplate mybatis;
	@Override
	public void insert(PsdVO vo) {
		mybatis.insert("psd.INSERT",vo);
	}
	@Override
	public PsdVO custno(PsdVO vo) {
		return mybatis.selectOne("psd.SELECT_CUSTNO");
	}
	@Override
	public List<PsdVO> getpsdlist(PsdVO vo) {
		if(vo.getCh1()==null || vo.getCh1().equals("")|| vo.getCh2().equals("")) {
			return mybatis.selectList("psd.SELECT_ALL");
		}else if(vo.getCh1().equals("custname")) {
			return mybatis.selectList("psd.SELECT_CUSTNAME","%"+vo.getCh2()+"%");
		}else if(vo.getCh1().equals("custno")) {
			return mybatis.selectList("psd.SELECT_CUSTNO1","%"+vo.getCh2()+"%");
		}
		return null;
		
	}
	@Override
	public PsdVO edit(PsdVO vo) {
		return mybatis.selectOne("psd.SELECT_ONE",vo);
		
	}
	@Override
	public void update(PsdVO vo) {
		System.out.println(vo);
		mybatis.update("psd.UPDATE",vo);
		
	}
	@Override
	public void delete(PsdVO vo) {
		mybatis.delete("psd.DELETE",vo);
	}
	@Override
	public List<PsdVO> shoplist(PsdVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectList("psd.SELECT_SHOP");
	}
	@Override
	public String idc(PsdVO vo) {
		// TODO Auto-generated method stub
		return mybatis.selectOne("psd.IDC",vo);
	}
	@Override
	public void shopinsert(PsdVO vo) {
		mybatis.insert("psd.INSERT_SHOP",vo);
		
	}

}
