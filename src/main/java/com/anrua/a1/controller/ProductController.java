package com.anrua.a1.controller;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.anrua.a1.product.ProductService;
import com.anrua.a1.product.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	String path="";
	@PostConstruct 
	public void init() {
		path = servletcontext.getRealPath("/product/files/");
		System.out.println("path:" + path);
	}
	@Autowired
	private ServletContext servletcontext;
	
	@RequestMapping("productform.do")
	public String insert(ProductVO vo) throws Exception {
		MultipartFile uploadFile = vo.getPimg();
		String filename = uploadFile.getOriginalFilename();
		File f = new File(path+filename);
		long time = System.currentTimeMillis();
		SimpleDateFormat daytime =new SimpleDateFormat("HHmmss");
		String now=daytime.format(time);
		System.out.println("시간확인:" +now);
		if(!uploadFile.isEmpty()) {
			if(f.exists()) {
				String onlyfilename =filename.substring(0,filename.lastIndexOf("."));
				String extension = filename.substring(filename.lastIndexOf("."));
				filename = onlyfilename+"_"+now+extension;
			}
			uploadFile.transferTo(new File(path+filename));
		}else {
			filename="space.png";
		}
		vo.setPimgstr(filename);
		service.insert(vo);
		return "/productlist.do";
	}
	
	@RequestMapping("productlist.do")
	public ModelAndView productlist(ModelAndView mav,ProductVO vo) {
		mav.addObject("li",service.productlist(vo));
		System.out.println(service.productlist(vo));
		mav.setViewName("/product/productlist.jsp");
		return mav;
	}
	
	@RequestMapping("productedit.do")
	public ModelAndView productedit(ModelAndView mav,ProductVO vo) {
		mav.addObject("p",service.productedit(vo));
		mav.setViewName("/product/productedit.jsp");
		return mav;
	}
	
	
	@RequestMapping("productdelelte.do")
	public String productdelelte(ProductVO vo) {
		service.delete(vo);
		return "/productlist.do";
	}
	
	
}
