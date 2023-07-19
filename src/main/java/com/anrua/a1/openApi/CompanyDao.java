package com.anrua.a1.openApi;

import java.util.List;

public interface CompanyDao {
	void insert(CompanyVO vo);
	void evinsert(EvSearchVO vo);
	List<EvSearchVO> evlist(EvSearchVO vo);
	EvSearchVO evedit(EvSearchVO vo);
	
	List<CompanyVO> list(CompanyVO vo);
	CompanyVO edit(CompanyVO vo);
}
