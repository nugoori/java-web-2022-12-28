package database.Entity;

// Entity: 데이터베이스의 테이블과 서로 매핑되는 Java Class
// 목적: 데이터베이스 테이블의 각각의 레코드를 인스턴스로 받기 위한 용도
// 조건: 데이터베이스 테이블의 각 컬럼명, 데이터타입과 Entity class의 필드명, 데이터타입이 일치해야함

// Board Table
// id INT AUTO_INCREMENT PRIMARY KEY
// boardTitle VARCHAR(200) NOT NULL
// boardContent TEXT NOT NULL
// boardDateTime DATETIME NOT NULL
// boardLike INT DEFAULT 0
// boardWriter INT NOT NULL

public class BoardEntity {
	
	private Integer id;
	private String boardTitle;
	private String boardContent;
	private String boardDateTime;
	private Integer boardLike;
	private Integer boardWriter;
	
	public BoardEntity(Integer id, String boardTitle, String boardContent, String boardDateTime, Integer boardLike,
			Integer boardWriter) {
		this.id = id;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDateTime = boardDateTime;
		this.boardLike = boardLike;
		this.boardWriter = boardWriter;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDateTime() {
		return boardDateTime;
	}
	public void setBoardDateTime(String boardDateTime) {
		this.boardDateTime = boardDateTime;
	}
	public Integer getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(Integer boardLike) {
		this.boardLike = boardLike;
	}
	public Integer getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(Integer boardWriter) {
		this.boardWriter = boardWriter;
	}

	@Override
	public String toString() {
		return "BoardEntity [id=" + id + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDateTime=" + boardDateTime + ", boardLike=" + boardLike + ", boardWriter=" + boardWriter
				+ "]";
	}

}







