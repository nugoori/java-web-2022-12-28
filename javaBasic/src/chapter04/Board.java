package chapter04;

import java.util.Date;

public class Board {
	private Integer boardNumber;
	private String boardTitle;
	private String boardWriter;
	private Date registDate;
	private String boardContent;
	
	public Board(Integer boardNumber, String boardTitle, String boardWriter, Date registDate, String boardContent) {
		this.boardNumber = boardNumber;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.registDate = registDate;
		this.boardContent = boardContent;
	}

	public Integer getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(Integer boardNumber) {
		this.boardNumber = boardNumber;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
}
