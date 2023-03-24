package board;

public class User {
	// 아이디
	private int id;
	// 비밀번호
	private String password;
	// 이름
	private String name;
	// 전화번호
	private String telNumber;
	
	// 생성자
	public User(int id, String password, String name, String telNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.telNumber = telNumber;
	}
	
	// getter, setter 메서드
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

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", telNumber=" + telNumber + "]";
	}
	
}






