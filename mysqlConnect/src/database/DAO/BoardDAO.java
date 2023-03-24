package database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.DatabaseConnector;
import database.Entity.BoardEntity;
import dto.DeleteBoardDTO;
import dto.InsertBoardDTO;
import dto.UpdateBoardDTO;

// DAO : Data Access Object
// 데이터베이스에 접근해서 데이터 검색 및 삽입 등의 데이터베이스 작업을 담당하는 클래스
public class BoardDAO {
	
	// 데이터베이스의 Board 테이블에서 입력받은 id에 해당하는 레코드를 모든 컬럼을 선택해서 반환하는 메서드
	// SQL: SELECT * FROM Board WHERE id = ?;
	// 예상 반환 결과: 0개 or 1개의 레코드
	public BoardEntity findById(Integer id) {
		
		BoardEntity result = null;
		
		final String SQL = "SELECT * FROM Board WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = DatabaseConnector.createConnection();
			preparedStatement = connection.prepareStatement(SQL);
			// SELECT * FROM Board WHERE id = ?
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String boardTitle = resultSet.getString(2);
				String boardContent = resultSet.getString(3);
				String boardDateTime = resultSet.getString(4);
				Integer boardLike = resultSet.getInt(5);
				Integer boardWriter = resultSet.getInt(6);
				
				result = new BoardEntity(id, boardTitle, boardContent, boardDateTime, boardLike, boardWriter);
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed())
					resultSet.close();
				if (preparedStatement != null && !preparedStatement.isClosed())
					preparedStatement.close();
				if (connection != null && !connection.isClosed())
					connection.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	// 데이터베이스의 Board 테이블에서 모든 컬럼을 선택해서 반환하는 메서드
	// SQL: SELECT * FROM Board;
	// 예상되는 반환 결과는 0개 이상의 복수의 레코드
	public List<BoardEntity> find() {
		List<BoardEntity> result = new ArrayList<BoardEntity>();
		
		final String SQL = "SELECT * FROM Board";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DatabaseConnector.createConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQL);
			
			while(resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String boardTitle = resultSet.getString(2);
				String boardContent = resultSet.getString(3);
				String boardDateTime = resultSet.getString(4);
				Integer boardLike = resultSet.getInt(5);
				Integer boardWriter = resultSet.getInt(6);
				
				BoardEntity entity = new BoardEntity(id, boardTitle, boardContent, boardDateTime, boardLike, boardWriter);
				result.add(entity);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed())
					resultSet.close();
				if (statement != null && !statement.isClosed())
					statement.close();
				if (connection != null && !connection.isClosed())
					connection.close();
			} catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		return result;
	}
	
	// 데이터베이스에서 Board 테이블에 레코드를 삽입
	// SQL: INSERT INTO Board (boardTitle, boardContent, boardDateTime, boardWriter)
	//      VALUES (?, ?, ?, ?);
	// 예상되는 반환 값: 0 or 1
	public int insert(InsertBoardDTO dto) {
		int result = 0;
		
		final String SQL = "INSERT INTO Board (boardTitle, boardContent, boardDateTime, boardWriter) VALUES (?, ?, ?, ?)";
		
		Connection connection = null;
		// PreparedStatement: 동적으로 SQL문의 값을 지정할 수 있도록 함
		PreparedStatement preparedStatement = null;
		
		SimpleDateFormat simpleDateFormat = 
				new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {
			connection = DatabaseConnector.createConnection();
			// PreparedStatement 객체 생성
			preparedStatement = connection.prepareStatement(SQL);
			
			// INSERT INTO Board (boardTitle, boardContent, boardDateTime, boardWriter) VALUES (?, ?, ?, ?)
			preparedStatement.setString(1, dto.getBoardTitle());
			preparedStatement.setString(2, dto.getBoardContent());
			preparedStatement.setString(3, simpleDateFormat.format(new Date()));
			preparedStatement.setInt(4, dto.getBoardWriter());
			
			result = preparedStatement.executeUpdate();
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed())
					preparedStatement.close();
				if (connection != null && !connection.isClosed())
					connection.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 데이터베이스에서 Board테이블의 레코드 중 입력받은 id에 해당하는 레코드의 
	// title과 content를 입력받은 값으로 수정
	// SQL: UPDATE Board SET boardTitle = ?, boardContent = ?
	//      WHERE id = ?;
	// 예상되는 반환 값: 0 or 1
	public int update(UpdateBoardDTO dto) {
		
		int result = 0;
		
		final String SQL = "UPDATE Board SET boardTitle = ?, boardContent = ? WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DatabaseConnector.createConnection();
			preparedStatement = connection.prepareStatement(SQL);
			// UPDATE Board SET boardTitle = ?, boardContent = ? WHERE id = ?
			preparedStatement.setString(1, dto.getBoardTitle());
			preparedStatement.setString(2, dto.getBoardContent());
			preparedStatement.setInt(3, dto.getId());
			
			result = preparedStatement.executeUpdate();
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed())
					preparedStatement.close();
				if (connection != null && !connection.isClosed())
					connection.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	// 데이터베이스에서 Board 테이블 중 입력받은 id에 해당하는 레코드를 삭제
	// SQL: DELETE FROM Board WHERE id = ?;
	// 예상 반환 값: 0 or 1
	public int delete(DeleteBoardDTO dto) {
		
		int result = 0;
		
		final String SQL = "DELETE FROM Board WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DatabaseConnector.createConnection();
			preparedStatement = connection.prepareStatement(SQL);
			// DELETE FROM Board WHERE id = ?
			preparedStatement.setInt(1, dto.getId());
			
			result = preparedStatement.executeUpdate();
			
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed())
					preparedStatement.close();
				if (connection != null && !connection.isClosed())
					connection.close();
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		return result;
		
	}

}













