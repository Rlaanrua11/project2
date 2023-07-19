package com.anrua.a1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anrua.a1.login.LoginService;
import com.anrua.a1.psd.PsdService;
import com.anrua.a1.psd.PsdVO;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("login.do")
	public String login(ModelAndView mav,PsdVO vo) {
		PsdVO m = service.loginone(vo);
		if(m==null || m.equals(null)) {
			return "/login/login.jsp";
		}else {
			if(BCrypt.checkpw(vo.getPassword(), m.getPassword())) {
				System.out.println("로그인 성공");
				session.setAttribute("m",m);
				return "/index.jsp";
			}else {
				System.out.println("암호가 일치하지 않습니다");
				return "/login/login.jsp";
			}
			
		}
		
	}
	@RequestMapping("logout.do")
	public String logout(ModelAndView mav,PsdVO vo) {
		session.invalidate();
		return "/index.jsp";
	}
}
