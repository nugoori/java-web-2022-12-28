package board;

import java.util.Date;

// 데이터베이스 테이블로 부터
// 추출해 온 Class는 **Entity라 명명 함
public class BoardEntity {
	// Entity class는
	// 멤버변수가 테이블의 필드명과
	// 일치해야함
	private int boardNumber;
	private String boardTitle;
	private String boardContent;
	private Date boardDate;
	private int boardWriter;
	
	public int getBoardNumber() {
		return boardNumber;
	}
	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
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
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(int boardWriter) {
		this.boardWriter = boardWriter;
	}
	
	public BoardEntity(int boardNumber, String boardTitle, String boardContent, Date boardDate, int boardWriter) {
		this.boardNumber = boardNumber;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardWriter = boardWriter;
	}
	
	@Override
	public String toString() {
		return "BoardEntity [boardNumber=" + boardNumber + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", boardDate=" + boardDate + ", boardWriter=" + boardWriter + "]";
	}
	
}







