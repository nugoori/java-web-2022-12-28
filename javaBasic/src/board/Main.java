package board;

import java.util.ArrayList;
import java.util.List;

// WAS 에서 처리하는 역할
// 회원 등록
// 회원 정보 보기
// 회원 정보 수정
// 회원 삭제
// 회원 리스트

// C. R. U. D.
public class Main {
	private List<User> database = new ArrayList<User>();
	
	// 완전 똑같은 로직으로 만들게 될 것
	// 회원 등록
	// id는 0이상의 수 여야 하고 password, name, telNumber 는 빈값이 아니면서 null도 아니어야 함
	private boolean createUser(int id, String password, String name, String telNumber) {
		// 파라미터가 정상적인 값인지 검증
		if (id < 0) return false;
		if (password.isEmpty() || name.isEmpty() || telNumber.isEmpty()) return false;
		if (password == null || name == null || telNumber == null) return false;
		// id 중복 체크
		if (checkOverlap(id)) return false;
		
		// 관리하고자 하는 객채를 생성
		User user = new User(id, password, name, telNumber);
		// 생성한 객체를 데이터베이스에 삽입
		database.add(user);
		// 삽입 결과를 반환
		return true;
	}
	// 회원 정보 보기
	private User readUser(int id) {
		// 파라미터가 정상적인 값인지 검증
		if ( id < 0) return null;
		// database에서 해당 id를 검색
		User user = selectUser(id);
		// 검색 결과를 반환
		return user;
	}
	// 회원 정보 수정
	// 3개이상의 파라미터를 받아올 경우 전송객체(DTO :Data Transfer Object)로 받아옴
	private User updateUser(UpdateUserDto dto) {
		int id = dto.getId();
		// 입력된 id 값 검증
		if (id < 0) return null;
		// 데이터 베이스에서 입력받은 id에 해당하는 user정보를 받아옴
		User user = selectUser(id);
		// 입력받은 id에 해당하는 user정보가 있는지 검증
		if (user == null) return null;
		// 입력받은 패스워드와 해당 유저의 패스워드가 같은지 검증
		String password = dto.getPassword();
		if ( !password.equals(user.getPassword())) return null;
		// 유저 정보 변경
		String name = dto.getName();
		String telNumber = dto.getTelNumber();
		user.setName(name);
		user.setTelNumber(telNumber); // for each를 사용했을 경우 ArrayList의 값 변경 함수 set(index, ..)을 사용했어야 함
	
		return user;
	}
	// 회원 삭제
	private boolean deleteUser(int id) {
		// 입력받은 id값 검증
		if (id < 0) return false;
		// 입력받은 id에 해당하는 user의 인덱스를 가져옴
		int index = getUserIndex(id);
		// index가 -1(존재하지 않는 id)인지 검증
		if (index == -1) return false;
		// database에서 해당 index요소 제거
		database.remove(index);
		
		return true;
	}
	// 회원 리스트
	private List<User> readUserList() {
		return database;
	}
	
	// 메인 메서드
	public static void main(String[] args) {
		
		while(true) {
			// 1. 생성 / 2.읽기 / 3.수정 / 4.삭제 / 5.리스트 불러오기 / 6.종료
			
		}
	}

	// 회원 아이디가 중복되는지 검사하는 메서드
	// for each 구문에서 반복을 돌릴경우 user의 복사 값(주소?)이 들어가기 때문에 들어가는 주소가 다를 수 있음
	private boolean checkOverlap(int id) {
		for (User user : database) {
			if (user.getId() == id) return true;
		}
		return false;
	}
	
	// 특정 회원 id를 database에서 검색하는 메서드 > 원래 SQL에서 담당
	private User selectUser(int id) {
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).getId() == id) return database.get(i);
		}
		return null;
	}
	
	// 특정 회원 아이디를 database에서 검색해서 해당 인덱스를 반환하는 메서드
	private int getUserIndex(int id) {
		for (int i= 0; i < database.size(); i++) {
			if (database.get(i).getId() == id) return i;
		}
		return -1; // 존재할 수 없느 인덱스 값
	}
	
	
}









