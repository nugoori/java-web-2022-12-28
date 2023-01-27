package chapter04;

public class Example02 {

	public static void main(String[] args) {
		String comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quam metus, rhoncus in lobortis id, condimentum quis arcu.";
		
		System.out.println(comment);
		
		// 문자열을 연결하는 String API method
		
		comment = comment.concat(comment);
		System.out.println(comment);
		
		// 문자열을 잘라내는 String API method  (substring **)
		String substr = comment.substring(6, 11);
		System.out.println(substr);
		
		// 주민등록번호에서 생년 - 생월 - 생일 - 성별
		String identityNumber = "930632-1111111";
		
		String year = identityNumber.substring(0, 2);
		String month = identityNumber.substring(2, 4);
		String day = identityNumber.substring(4, 6);
		String gender = identityNumber.substring(7, 8);
		
		System.out.println("year : " + year + " month : " + month + " day : " + day +  " gender : " + gender ); 
		
		// 문자열의 길이를 가져오는 String API method  (length **)
		int strLength = comment.length();
		System.out.println("strLength : " + strLength);
		
		// 문자열을 모두 대문자로 변셩시키는 String API method
		comment = comment.toUpperCase();
		System.out.println(comment);
		
		comment = comment.toLowerCase();
		System.out.println(comment);
		
		// 입력 받는 것이 믄지열의 구분자일 경우
		// Category : Top, Bottom -> 
		
		// 해당 인덱스 자리에 위치한 문자를 구하는 String API method
		char character = comment.charAt(2);
		System.out.println(character);
		
		// 해당 문자열이 몇 번쨰 인덱스에 존재하는지 구하는 String API method
		// 첫 번째로 검색되는 인덱스 위치를 반환
		int stringIndex = comment.indexOf("dolor");
		System.out.println(stringIndex);
		
		// 해당 문자열을 비교한 결과를 구하는 String API method
		boolean flag = comment.equals("dolor");
		System.out.println(flag);
		
		// 문자열의 앞, 뒤 공백을 제거하는 String API method (trim **)
		String blankStr = " blank blank ";
		System.out.println(blankStr);
		blankStr = blankStr.trim();
		System.out.println(blankStr);
		
		// 특정한 문자를 다른 문자로 바꾸는 String API method (replaceAll **)
		comment = comment.replaceAll("lorem", "merol");
		System.out.println(comment);
		
		blankStr = " blank blank ";
		System.out.println(blankStr);
		blankStr = blankStr.replaceAll(" ", "");
		System.out.println(blankStr);
		
		
		
		

	}

}
