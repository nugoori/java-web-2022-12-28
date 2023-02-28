//# typescript의 기본 데이터타입
//? 숫자 타입: number
//? 문자열 타입: string
//? 논리 타입: boolean

//# typescript의 변수 선언 방식
//? var: 변수, let: 변수, const: 상수

//# java에서의 변수 선언
//? 접근제어자 기타제어자 데이터타입 변수명;

//# typescript에서의 변수 선언
//? var 변수명; | let 변수명: 데이터타입;
var tmp;
let tmp2: number;
let tmp4 = 10;

//# typescript에서의 상수 선언
//? const 상수명 = 값;
const tmp3 = 'constant';

//# typescript에서의 비교연산자
let a: any = 10;
let b: any = '10';

//# == , != : 값만 비교
//? alert(a == b);

//# === , !== : 값과 타입까지 비교 
//^ (>== - 이런형태는 존재하지 않음)
// alert(a === b);

//# typescript에서의 나눗셈 연산
let tmp5 = 10 / 3; // 3.33333
// alert(tmp5);

//# java에서 객체 생성
//? 접근제어자 기타제어자 클래스 참조변수명 = new 생성자(인자, ...);

//# typescript에서 객체생성
//? const 참조변수명[: 클래스명] = new 생성자(인자, ...);
//? const 참조변수명[: 클래스명] = { key: value, ... };
//? const 참조변수명[: 인터페이스명] = { key: value, ... };

//# typescript에서 인터페이스를 선언하는 방법
//? interface 인터페이스명 { 필드명: 타입; ... }
interface Human {
    name: string;
    age: number;
}

const me = { name: '지훈', age: 31 };
const me2: Human = { name: '지훈', age: 31 };
// const me3: Human = { name: '지훈', aeg: 31 };

//^ typescript에서는 {} 를 배열이 아닌 객체의 묶음으로 표현
//^ 이렇게 {} 묶어서 객체를 표현하는 방식을 JSON 포멧이라 함
//^ 배열의 묶음은 []로 표현함

export default tmp;