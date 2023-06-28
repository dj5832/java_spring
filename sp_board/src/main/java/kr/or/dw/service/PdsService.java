package kr.or.dw.service;

import java.sql.SQLException;

import kr.or.dw.vo.PdsVO;

public interface PdsService {

	void regist(PdsVO pds) throws SQLException;
	
}
