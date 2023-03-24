package dto;

public class DeleteBoardDTO {
	
	private Integer id;

	public DeleteBoardDTO(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DeleteBoardDTO [id=" + id + "]";
	}

}
