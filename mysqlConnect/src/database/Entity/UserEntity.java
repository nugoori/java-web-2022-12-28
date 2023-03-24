package database.Entity;

public class UserEntity {
	private Integer id;
	private String password;
	private String name;
	private String telNumber;
	
	public UserEntity(Integer id, String password, String name, String telNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.telNumber = telNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "UserEntity [id=" + id + ", password=" + password + ", name=" + name + ", telNumber=" + telNumber + "]";
	}
}
