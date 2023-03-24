package dto;

public class UpdateBoardDTO {

	private Integer id;
	private String boardTitle;
	private String boardContent;
	
	public UpdateBoardDTO(Integer id, String boardTitle, String boardContent) {
		this.id = id;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
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

	@Override
	public String toString() {
		return "UpdateBoardDTO [id=" + id + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + "]";
	}
	
}
