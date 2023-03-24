package index;

import java.util.List;
import java.util.Scanner;

import database.Entity.BoardEntity;
import dto.DeleteBoardDTO;
import dto.InsertBoardDTO;
import dto.UpdateBoardDTO;
import service.BoardService;

public class MainApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		
		BoardService boardService = new BoardService();
		
		if (path.equals("POST /board")) {
			///////////////////////////////////////////////////////
			// 사용자로부터 입력을 받음
			System.out.println("boardTitle : ");
			String boardTitle = scanner.nextLine();
			System.out.println("boardContent : ");
			String boardContent = scanner.nextLine();
			System.out.println("boardWriter : ");
			Integer boardWriter = scanner.nextInt();
			
			///////////////////////////////////////////////////////
			// 입력을 검증
			if (boardTitle.isBlank() || boardContent.isBlank() || boardWriter < 0)
				System.out.println("Invalid Input");
			
			///////////////////////////////////////////////////////
			// Service Layer 전송할 DTO 생성
			InsertBoardDTO insertBoardDto = 
					new InsertBoardDTO(boardTitle, boardContent, boardWriter);
			
			///////////////////////////////////////////////////////
			// 실제 비즈니스 로직을 실행하기 위해 Service의 메서드를 호출
			int result = boardService.postBoard(insertBoardDto);
			
			///////////////////////////////////////////////////////
			// 비즈니스 로직의 결과에 따라 결과를 출력
			if (result == 1) System.out.println("Insert Success");
			else System.out.println("Insert Failed");
		}
		else if (path.equals("GET /boardList")) {
			
			///////////////////////////////////////////////////////
			// 실제 비즈니스 로직을 실행하기 위해 Service의 메서드 호출
			List<BoardEntity> boardList = boardService.getBoardList();
			
			///////////////////////////////////////////////////////
			// 비즈니스 로직 결과를 출력
			for (BoardEntity board: boardList)
				System.out.println(board.toString());
			
		}
		else if (path.equals("PATCH /board")) {
			
			///////////////////////////////////////////////////////
			// 사용자로부터 입력을 받음
			System.out.println("boardTitle : ");
			String boardTitle = scanner.nextLine();
			System.out.println("boardContent : ");
			String boardContent = scanner.nextLine();
			System.out.println("id : ");
			Integer id = scanner.nextInt();
			
			///////////////////////////////////////////////////////
			// 입력을 검증
			if (boardTitle.isBlank() || boardContent.isBlank() || id < 0)
				System.out.println("Invalid Input");
			
			///////////////////////////////////////////////////////
			// Service Layer 전송할 DTO 생성
			UpdateBoardDTO updateBoardDto = 
					new UpdateBoardDTO(id, boardTitle, boardContent);
			
			///////////////////////////////////////////////////////
			// 실제 비즈니스 로직을 실행하기 위해 Service의 메서드를 호출
			int result = boardService.patchBoard(updateBoardDto);
			
			///////////////////////////////////////////////////////
			// 비즈니스 로직의 결과에 따라 결과를 출력
			if (result == 1) System.out.println("Update Success");
			else if (result == -1) System.out.println("Does Not Exist Board Id");
			else System.out.println("Update Failed");
		}
		else if (path.equals("DELETE /board")) {
			
			///////////////////////////////////////////////////////
			// 사용자로부터 입력을 받음
			System.out.println("id : ");
			Integer id = scanner.nextInt();
			
			///////////////////////////////////////////////////////
			// 입력을 검증
			if (id < 0) System.out.println("Invalid Input");
			
			///////////////////////////////////////////////////////
			// Service Layer 전송할 DTO 생성
			DeleteBoardDTO deleteBoardDto = new DeleteBoardDTO(id);
			
			///////////////////////////////////////////////////////
			// 실제 비즈니스 로직을 실행하기 위해 Service의 메서드를 호출
			int result = boardService.deleteBoard(deleteBoardDto);
			
			///////////////////////////////////////////////////////
			// 비즈니스 로직의 결과에 따라 결과를 출력
			if (result == 1) System.out.println("Delete Success");
			else System.out.println("Delete Failed");
		}
		else {
			System.out.println("404 Not found");
		}
		
	}

}





