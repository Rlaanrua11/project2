package com.anrua.a1.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anrua.a1.psd.PsdService;
import com.anrua.a1.psd.PsdVO;

@Controller
public class PsdController {
	@Autowired
	private PsdService service;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("insertPsd.do")
	public String insertPsd(PsdVO vo) {
		service.insert(vo);
		return "getpsdlist.do";
	}
	
	@RequestMapping("getpsdlist.do")
	public ModelAndView getpsdlist(PsdVO vo,ModelAndView mav) {
		mav.addObject("li",service.getpsdlist(vo));
		mav.setViewName("/psd/getpsdlist.jsp");
		return mav;
		
	}

	@RequestMapping("shopform.do")
	public ModelAndView form(PsdVO vo,ModelAndView mav) {
		mav.addObject("m",service.custno(vo));
		mav.setViewName("/shop/shopform.jsp");
		return mav;
		
	}
	
	@RequestMapping("editpsd.do")
	public String editpsd(PsdVO vo,ModelAndView mav) {
		session.setAttribute("m",service.edit(vo));
		return "/psd/edit.jsp";
		
	}
	
	@RequestMapping("updatepsd.do")
	public String updatepsd(PsdVO vo) {
		service.update(vo);
		return "getpsdlist.do";
	}
	
	@RequestMapping("deletepsd.do")
	public String deletepsd(PsdVO vo) {
		service.delete(vo);
		return "getpsdlist.do";
	}
	
	@RequestMapping("shoplist.do")
	public ModelAndView shoplist(PsdVO vo,ModelAndView mav) {
		mav.addObject("li",service.shoplist(vo));
		mav.setViewName("/shop/shoplist.jsp");
		return mav;
	}
	@RequestMapping("idc.do")
	void idc(PsdVO vo, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String str = service.idc(vo);
		System.out.println("====>str:"+str);
		if (str==null) {
		      if (vo.getId()!="") {	
		        out.print("T");
		      }
		    }else {
		      out.print("F");	
		    }
	   
	}
	@RequestMapping("insertshop.do")
	public String insertshop(PsdVO vo) {
		String password = BCrypt.hashpw(vo.getPassword(),BCrypt.gensalt());
		vo.setPassword(password);
		service.shopinsert(vo);
		return "shoplist.do";
	}
}
