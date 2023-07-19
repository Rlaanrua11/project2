package com.anrua.a1.product;

import java.sql.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductVO {
	private int pid;
	private int pprice;
	private String pdesc;
	private String pname;
	private String pimgstr;
	private Date pdate;
	private MultipartFile pimg;
	
}
