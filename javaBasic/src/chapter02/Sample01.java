package chapter02;

import java.util.Scanner;

// 게시물 작성
// 게시물 목록
// 게시물 상세 보기
// 게시물 수정
class Board {
	// 게시물 구분자
	int id;
	// 제목
	String title;
	// 작성자
	String writer;
	// 작성 날짜 및 시간
	String writeDate;
	// 내용
	String contents;
	// 좋아요
	int like;
	
	void contractionPrint() {
		System.out.println("게시물 구분자 : " + id + " / 게시물 제목 : " + title + " / 작성자 : " + writer);
	}
	
	void detailPrint() {
		System.out.println("title     : " + title);
		System.out.println("writer    : " + writer);
		System.out.println("writeDate : " + writeDate);
		System.out.println("contents  : " + contents);
		System.out.println("like      : " + like);
	}
}

public class Sample01 {
	
	final static Board[] BOARD_LIST = new Board[3];
	
	// 코드의 구조화를 위한 메서드 작성
	// static으로 작성
	
	// 게시물 작성 기능
	public static void writeBoard() {
		// 입력이 완료되면 게시물이 자동 등록됨
		// 등록이 완료되면 처음화면으로 돌아옴
		System.out.println("게시물 작성");
		
		for (int i = 0; i < BOARD_LIST.length; i++) {
			if (BOARD_LIST[i] != null) continue;

			BOARD_LIST[i] = new Board();

			BOARD_LIST[i].id = i;
			setBoard(i);
			
			break;
		}
	}
	
	// 게시물 목록 보기
	public static int getBoardList() {
		System.out.println("게시물 목록");
		
		// BOARD_LIST 배열에서 요소를 하나씩 꺼내옴
		for (Board board : BOARD_LIST) {
			// 꺼낸 board 요소가 null이면 다음 요소를 꺼내옴
			if (board == null) continue;
			board.contractionPrint();
		}
		
		Scanner selector = new Scanner(System.in);
		
		// 게시물 목록에서 특정 게시물 구분자를 입력하면 해당 게시물의 상세 내용을 보여줌
		System.out.println("게시물을 선택하세요. (-1을 입력하면 처음화면으로 돌아갑니다.)");
		int selectBoardId = selector.nextInt();

		if (selectBoardId >= BOARD_LIST.length) {
			System.out.println("3 이상의 게시물은 없습니다.");
			// 재귀 함수로 자기 자신을 다시 호출
			getBoardList();
			return 0;
		}
		if (selectBoardId < -1) {
			System.out.println("잘못된 입력입니다.");
			getBoardList();
			return 0;
		}
		// 만약 -1을 입력하면 처음화면으로 돌아옴
		if (selectBoardId == -1) {
			return 0;
		}
		BOARD_LIST[selectBoardId].detailPrint();
		
		// 게시물 상세에서 수정하기를 선택하면 수정을 할 수 있음 
		System.out.println("1. 수정 / 0. 처음으로");
		int updateSelect = selector.nextInt();
		// 수정이 완료되면 처음화면으로 돌아옴
		if (updateSelect == 0) return 0;
		
		setBoard(selectBoardId);

		return 0;
	}
	
	// 게시물 세팅 메서드
	static void setBoard(int i) {
		Scanner writer = new Scanner(System.in);
		
		System.out.println("타이틀 : ");
		BOARD_LIST[i].title = writer.nextLine();
		System.out.println("작성자 : ");
		BOARD_LIST[i].writer = writer.nextLine();
		System.out.println("작성 날짜 및 시간 : ");
		BOARD_LIST[i].writeDate = writer.nextLine();
		System.out.println("내용 : ");
		BOARD_LIST[i].contents = writer.nextLine();
	}

	public static void main(String[] args) {
		// 프로그램은 사용자가 종료를 하기전까지 계속 실행되어야 함
		// 사용자로부터 입력을 받아
		boolean power = true;

		Scanner scanner = new Scanner(System.in);
		Scanner writer = new Scanner(System.in);
		while(power) {
			// 게시물 작성, 게시물 목록 기능을 선택할 수 있음
			System.out.println("1. 게시물 작성 / 2. 게시물 목록 / 0. 종료");
			int mainSelectNumber = scanner.nextInt();

			if (mainSelectNumber < 0 || mainSelectNumber > 2) {
				System.out.println("잘못된 번호를 선택했습니다.");
				continue;
			}
			// 게시물 작성을 선택하면 타이틀, 작성자, 작성 날짜 및 시간, 내용을 입력할 수 있음
			if (mainSelectNumber == 1) writeBoard();
			
			// 게시물 목록을 선택하면 작성된 게시물을 모두 보여줌 (게시물 구분자, 게시물 제목, 작성자만 출력)
			if (mainSelectNumber == 2) getBoardList();
			
			// 처음 화면일 시 종료를 선택하면 프로그램이 종료됨
			if (mainSelectNumber == 0) {
				System.out.println("프로그램 종료");
				// 1. while문의 조건을 false
				power = false;
				// 2. break문으로 while문을 강제 종료
				// break;
				// 3. return문으로 main 메서드를 종료
				// return;
			}
		}
	}

}








