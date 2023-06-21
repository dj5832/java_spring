package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.dw.vo.MemberVO;

@Mapper
public interface MemberDAO {
	
	// 회원정보 조회
	MemberVO selectMemberById(String id) throws SQLException;

	// 모든 회원 정보 조회
	List<MemberVO> selectMemberList() throws SQLException;

	// 멤바 등록
	void insertMember(MemberVO member) throws SQLException;

	// 멤버 상세정보 수정
	void updateMember(MemberVO member) throws SQLException;

	// 멤버 삭제
	void deleteMember(String id) throws SQLException;

	// 멤버 정지
//	void stopMember(String id) throws SQLException;

	// 멤버 정지
	void disabledMember(String id) throws SQLException;
	
}
