package com.anrua.a1.psd;

import java.util.List;

public interface PsdDao {
	void insert(PsdVO vo);
	void shopinsert(PsdVO vo);

	void update(PsdVO vo);
	void delete(PsdVO vo);
	PsdVO edit(PsdVO vo);
	PsdVO custno(PsdVO vo);
	List<PsdVO> getpsdlist(PsdVO vo);
	List<PsdVO> shoplist(PsdVO vo);
	String idc(PsdVO vo);
}
