package chapter01;

import java.util.Scanner;

public class Sample02 {

//	회원가입 프로세스를 사용한 변수 및 조건문 활용
//	1. 사용자로부터 이메일, 비밀번호, 비밀번호 확인, 닉네임, 주소, 상세주소 입력받음
//	2. 모든값이 입력 됐는지 검증
//	2-1. 하나라도 입력이 되지 않으면 "모두 입력하세요." 출력 후 프로그램 종료
//	3. 비밀번호와 확인이 서로 같은지 확인
//	3-1. 서로 같지 않다면 "비밀번호가 서로 다릅니다." 출력 후 프로그램 종료
//	4. 입력받은 데이터를 메모리에 저장 및 출력 후 프로그램 종료
	public static void main(String[] args) {
		
//		1. 사용자로부터 이메일, 비밀번호, 비밀번호 확인, 닉네임, 주소, 상세주소 입력받음
		Scanner sc = new Scanner(System.in);
		
		String email;
		String password;
		String passwordcheck;
		String nickname;
		String address;
		String addressDetail;
		
		System.out.println("이메일 : ");
		email = sc.nextLine();
		System.out.println("비밀번호 : ");
		password = sc.nextLine();
		System.out.println("비밀번호 확인 : ");
		passwordcheck = sc.nextLine();
		System.out.println("닉네임 : ");
		nickname = sc.nextLine();
		System.out.println("주소 : ");
		address = sc.nextLine();
		System.out.println("상세주소 : ");
		addressDetail = sc.nextLine();
		
//		2. 모든값이 입력 됐는지 검증		
//		2-1. 하나라도 입력이 되지 않으면 "모두 입력하세요." 출력 후 프로그램 종료
		if ( email.isEmpty() || password.isEmpty() || passwordcheck.isEmpty() 
		  || nickname.isEmpty() || address.isEmpty() || addressDetail.isEmpty() ) {
			System.out.println("모두 입력하세요.");
			return;
		}
		
//		3. 비밀번호와 확인이 서로 같은지 확인		
//		3-1. 서로 같지 않다면 "비밀번호가 서로 다릅니다." 출력 후 프로그램 종료
		if (!password.equals(passwordcheck)) {
			System.out.println("비밀번호가 서로 다릅니다.");
			return;
		}
		
//		4. 입력받은 데이터를 메모리에 저장 및 출력 후 프로그램 종료
		System.out.println("이메일 : " + email + " / 닉네임 : " + nickname);
		
		
		
	}

}