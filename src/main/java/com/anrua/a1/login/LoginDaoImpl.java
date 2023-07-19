package com.anrua.a1.login;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anrua.a1.psd.PsdVO;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	@Override
	public PsdVO loginone(PsdVO vo) {
		return mybatis.selectOne("psd.SELECT_LOGIN",vo);
	}
	
}
