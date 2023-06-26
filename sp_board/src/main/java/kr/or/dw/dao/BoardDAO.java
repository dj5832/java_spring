package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.BoardVO;

@Mapper
public interface BoardDAO {

	List<BoardVO> selectSearchBoardList(SearchCriteria cri, RowBounds rowBounds) throws SQLException;

	int selectSearchBoardListCount(SearchCriteria cri) throws SQLException;

	void insertBoard(BoardVO board) throws SQLException;

	BoardVO selectBoard(int bno) throws SQLException;

	void increaseViewCnt(int bno) throws SQLException;

	void updateBoard(BoardVO board) throws SQLException;

	void removeBoard(int bno) throws SQLException;

	
}
