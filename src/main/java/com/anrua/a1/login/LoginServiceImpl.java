package com.anrua.a1.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anrua.a1.psd.PsdVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao dao;
	
	@Override
	public PsdVO loginone(PsdVO vo) {
		// TODO Auto-generated method stub
		return dao.loginone(vo);
	}

}
