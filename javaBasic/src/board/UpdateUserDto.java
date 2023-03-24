package board;

// DTO: Data Transfer Object
// 데이터 전송 객체
// 서로 다른 레이어 간에 데이터를 송수신 할때 사용되는 객체
public class UpdateUserDto {
	private int id;
	private String password;
	private String name;
	private String telNumber;
	
	// constructor
	public UpdateUserDto(int id, String password, String name, String telNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.telNumber = telNumber;
	}
	
	// getter, setter
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
}
