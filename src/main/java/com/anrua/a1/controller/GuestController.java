package com.anrua.a1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anrua.a1.guestbook.GuestService;
import com.anrua.a1.guestbook.GuestVO;

@Controller
public class GuestController {

		@Autowired
		private GuestService service;
		
		@RequestMapping("guestinsert.do")
		public String guestinsert(GuestVO vo) {
			String[]  str1={"김","이","박","최","나","석","윤"};
			String[]  str2={"둘리","하니","똘이","영심","만수","지효","하늘이"};
			String[]  title={"상품 너무 좋아요","적극 추천합니다.","배송이 빨라요","감사합니다.","보통이에요"};
			for (int i=1 ; i<=555 ; i++) {
				
				int k1 = (int) (Math.random()*7) ; 
				int k2 = (int) (Math.random()*7) ; 
				
				int t = (int) (Math.random()*5) ; 
				
				vo.setTitle(title[t]); 
				vo.setWriter(str1[k1]+str2[k2]);
				service.insert(vo);	
				
			}
			return "/guestlist.do";
			
		}
		
		@RequestMapping("guestlist.do")
		public ModelAndView guestlist(GuestVO vo,ModelAndView mav) {
			mav.addObject("li",service.list(vo));
			int totalcount=service.count(vo);
			mav.addObject("totalcount",totalcount);
			mav.setViewName("/cart/guestlist.jsp");
			return mav ;
			
		}
}
