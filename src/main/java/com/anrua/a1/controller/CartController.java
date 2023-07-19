package com.anrua.a1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anrua.a1.cart.CartService;
import com.anrua.a1.cart.CartVO;
import com.anrua.a1.cart.OrderjVO;
import com.anrua.a1.cart.OrdermVO;

@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	
	@RequestMapping("orderlist.do")
	public  ModelAndView orderlist(ModelAndView mav, OrdermVO vo) {
		mav.addObject("li1",service.orderlist(vo));
		mav.setViewName("/cart/orderlist.jsp");
		return mav;
	}
	
	@RequestMapping("cartinsert.do")
	public String cartinsert(CartVO vo) {
		service.insert(vo);
		return "/cartlist.do";
		
	}
	
	@RequestMapping("cartlist.do")
	public ModelAndView cartlist(ModelAndView mav, CartVO vo) {
		mav.addObject("li1",service.cartlist(vo));
		mav.setViewName("/cart/cartlist.jsp");
		return mav;
	}
	
	@RequestMapping("deleteonecart.do")
	public String deleteonecart(CartVO vo) {
		service.deleteone(vo);
		return "/cartlist.do";
		
	}
	
	@RequestMapping("deleteallcart.do")
	public String deleteallcart(CartVO vo) {
		service.deleteall(vo);
		return "/cartlist.do";
		
	}
	
	@RequestMapping("cartupdate.do")
	public String cartupdate(
		@RequestParam String[] cid,
		@RequestParam String[] custno,
		@RequestParam String[] pid,
		@RequestParam String[] amount    ) throws Exception { 
	
	String custnostr ="";
	for (int i=0 ; i < cid.length ; i++) {    		
		CartVO vo = new 	CartVO();
		custnostr  = custno[i];
		vo.setCid(Integer.parseInt(cid[i]));
		vo.setAmount(Integer.parseInt(amount[i]));    	 
		service.update(vo);     	
	}
	return "redirect:/cartlist.do?custno="+custnostr;	
	}
	
	 @RequestMapping("order.do")
	 public String  order(
				@RequestParam String[] cid,
				@RequestParam String[] custno,
				@RequestParam String[] pid,
				@RequestParam String[] pname,
				@RequestParam String[] amount ,
				OrdermVO mvo) throws Exception { 
	    	mvo.setOcustno(Integer.parseInt(custno[0]));
	    	System.out.println(mvo);
	    	service.insertmoney(mvo);
	    	OrdermVO vo = service.orderg(mvo);
	    	
	    	int custNoStr = 0;
	    	for (int i=0 ; i < cid.length ; i++) {    		
	    		OrderjVO  Ovo = new 	OrderjVO();
	    	   custNoStr  = Integer.parseInt(custno[i]);
	    	   Ovo.setCustno(Integer.parseInt(custno[i]));
	    	   Ovo.setCid(Integer.parseInt(cid[i]));
	    	   Ovo.setPid(Integer.parseInt(pid[i]));
	    	   Ovo.setPname(pname[i]);
	    	   Ovo.setAmount(Integer.parseInt(amount[i]));
	    	   Ovo.setOrderg(vo.getIdx());
	    	   service.insertorder(Ovo);
	    	   
	    	}
	    	String custNoK = String.valueOf(custNoStr);
			return "redirect:/deleteallcart.do?custno="+custNoK;
			
		}
	 

	
}
