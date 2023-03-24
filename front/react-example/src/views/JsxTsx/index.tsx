import React from 'react'

//# JSX, TSX 
//? JSX : Javascript 기반
//? TSX : Typescript 기반

//? TSX
//? - TypeScript XML 
//^ XML : eXtensible Markup Language
//? - React에서 Typescript로 HTML을 작성할 수 있도록 하는 파일

export default function JsxTsx() {

  const text = 'JSX + TSX';

  const trueFlag = true;
  const falseFlag = false;

  const numberArray = [1, 2, 3, 4, 5];

  //# 1. tsx 파일에서 작성된 Typescript 컴포넌트 함수는
  //# return의 () 안에 html 태그를 포함할 수 있음
  //? typescript return에 html을 표기하려면 ()로 묶어줘야함
  //^ return ()안에는 최상위 부모 태그가 무조건 1개 있어야 함
  //! 0개도 안됨!!

  //? return () 안에서 Typescript를 사용하려면 {}로 묶어서 작성해야함
  //^ {}를 써서 Typescript를 작성하고 싶으면 필수적으로 html 태그 안에 있어야함

  //? return () 안의 {} 안에서 다시 html을 표기하려면 ()로 반환을 해야줘야함

  //# 2. return () 안에서는 제어문을 사용할 수 없음
  //? if 문 / for 문을 사용할 수 없음
  //? 변수와 연산자만 사용가능

  //? if 문 대체 : 논리연산자 / 삼항연산자
  //? for 문 대체 : 배열 객체의 map 메서드를 사용

  //# 3. return () 안에서는 html 주석이 사용되지 않음
  //? {}를 사용하여 Typescript 주석을 사용해야함

  //# 4. TSX는 xml 기반으로 HTML을 표기하기 때문에 문법이 정확해야함
  //? 모든 태그를 다 닫아줘야 하고 모든 html 요소를 소문자로 작성
  //? html 속성이 대소문자를 구분

  const TRUE_TEXT = 'true';

  return (
    <div>
      { trueFlag && (<div>{TRUE_TEXT}</div>) }
      { falseFlag && (<div>false</div>) }
      { trueFlag || (<div>or True</div>) }
      { falseFlag || (<div>or False</div>) }
      { trueFlag ? (<div>true</div>) : (<div>false</div>) }
      { numberArray.map((number) => (<div>{number}</div>)) }
    </div>
  )
}
