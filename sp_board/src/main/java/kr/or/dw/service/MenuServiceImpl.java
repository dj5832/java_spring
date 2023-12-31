package kr.or.dw.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dw.dao.MenuDAO;
import kr.or.dw.vo.MenuVO;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDAO menuDAO;	// == MenuDAOImpl.getInstance();
	
	@Override
	public List<MenuVO> selectMainMenuList() throws SQLException {
		
		List<MenuVO> menuList = menuDAO.selectMainMenuList();
		
		return menuList;
	}

	@Override
	public List<MenuVO> selectSubMenuList(String mcode) throws SQLException {
		
		List<MenuVO> menuList = menuDAO.selectSubMenuList(mcode);
		
		return menuList;
	}

	@Override
	public MenuVO selectMenuByMcode(String mcode) throws SQLException {
		return menuDAO.selectMenuByMcode(mcode);
	}

}
