package service;

import java.util.List;

import database.DAO.BoardDAO;
import database.DAO.UserDAO;
import database.Entity.BoardEntity;
import database.Entity.UserEntity;
import dto.DeleteBoardDTO;
import dto.InsertBoardDTO;
import dto.UpdateBoardDTO;

// 실제 비즈니스 로직을 수행하는 Layer
public class BoardService {
	
	private BoardDAO boardDao;
	private UserDAO userDao;
	
	public BoardService() {
		this.boardDao = new BoardDAO();
		this.userDao = new UserDAO();
	}

	public int postBoard(InsertBoardDTO insertBoardDto) {
		UserEntity userEntity = userDao.findById(insertBoardDto.getBoardWriter());
		if (userEntity == null) return 0;
		
		return boardDao.insert(insertBoardDto);
	}
	
	public List<BoardEntity> getBoardList() {
		return boardDao.find();
	}
	
	public int patchBoard(UpdateBoardDTO updateBoardDto) {
		Integer id = updateBoardDto.getId();
		
		// 존재하는 Board id 인지 검증
		BoardEntity boardEntity = boardDao.findById(id);
		if (boardEntity == null) return -1;
		
		return boardDao.update(updateBoardDto);
	}
	
	public int deleteBoard(DeleteBoardDTO deleteBoardDto) {
		return boardDao.delete(deleteBoardDto);
	}
	
}







