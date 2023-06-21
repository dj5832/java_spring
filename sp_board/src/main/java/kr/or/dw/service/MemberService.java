package kr.or.dw.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.or.dw.vo.MemberVO;

public interface MemberService {
	
	// 로그인
	void login(String id, String pwd, HttpSession session) throws SQLException;
	
	// 멤버 리스트 조회
	List<MemberVO> selectMemberList() throws SQLException;

	// 멤버 조회
	MemberVO selectMemberById(String id) throws SQLException;

	// 멤버 등록
	void regist(MemberVO member) throws SQLException;

	// 멤버 상세정보 수정
	void modify(MemberVO member) throws SQLException;

	// 멤버 삭제
//	void delete(String id) throws SQLException;

	// 멤버 정지
//	void stop(String id) throws SQLException;

	// 멤버 삭제
	void remove(String id)throws SQLException;

	// 멤버 정지
	void disabled(String id) throws SQLException;





	
}
