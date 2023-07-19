package com.anrua.a1.guestbook;

import java.util.List;

public interface GuestService {
	void insert(GuestVO vo);
	int count(GuestVO vo);
	List<GuestVO> list(GuestVO vo);
}
