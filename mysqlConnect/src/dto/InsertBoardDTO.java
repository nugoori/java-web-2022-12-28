package dto;

public class InsertBoardDTO {

	private String boardTitle;
	private String boardContent;
	private Integer boardWriter;
	
	public InsertBoardDTO(String boardTitle, String boardContent, Integer boardWriter) {
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
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
	public Integer getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(Integer boardWriter) {
		this.boardWriter = boardWriter;
	}

	@Override
	public String toString() {
		return "InsertBoardDTO [boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardWriter="
				+ boardWriter + "]";
	} 
	
}
