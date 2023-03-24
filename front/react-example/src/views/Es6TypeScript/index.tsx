import React from 'react'

export default function Es6Typescript() {
    //# 1. 변수 선언 
    //? 변수를 선언하는 방법
    //? ES6 -> let 변수명;
    //? TS  -> let 변수명: 데이터타입;
    let integer;
    let integer2: number;
    
    //# 2. 상수 선언 
    //? 상수를 선언하는 방법
    //? ES6 -> const 상수명 = 초기값;
    //? TS  -> const 상수명: 데이터타입 = 초기값;
    const INTEGER = 10;
    const INTEGER2: number = 10;

    //^ Typescript의 경우 변수 혹은 상수를 선언과 동시에 초기화하면
    //^ 해당 변수 혹은 상수의 데이터타입을 자동으로 추론함
    //? typeof(변수) -> 해당 변수의 타입을 문자열로 나타내줌 
    console.log(typeof(INTEGER));

    //# 3. 데이터 타입 
    //? TS -> string, number, boolean, null, undefined, any, object
    
    //? string: 문자열
    //? 문자열을 표현할 때는 '', "", ``
    let str: string = '10';
    // str = 10;
    const description = "str의 값은 " + str + "입니다.";
    const description2 = `str의 값은 ${str}입니다.`;
    // alert(description2);

    //? number: 숫자
    //? 실수와 정수를 모두 포함
    let num: number = 10;
    // num = 3.14;

    //? boolean: 논리
    let bool: boolean = true;

    //? null: 아무것도 지정되지 않은 상태
    // str = null;
    let n: null = null;

    //? undefined: 정의 되지 않은 상태
    const obj: any = {};
    console.log(obj.a);

    //? any: 모든 타입을 받는 타입
    let variable: any = 'str';
    variable = 10;

    //? object: 객체 타입 (Java의 Object class와 동일)
    let object: object = {};
    object = { a: 10 };
    object = [10, 20];
    // object = null;
    // object = 10;
    // object = '10';

    //? | , &
    //? | : 한 변수에 두 개 이상의 데이터타입을 지정해줄 때 사용
    let variable2: string | number | null;
    variable2 = 'str';
    variable2 = 10;
    variable2 = null;

    //! 역으로 생각했을 때 데이터 타입이 지정된 변수는 필수적으로 값이 포함되어 있어야 한다는 뜻
    // let variable3: string = null;
    
    //? & : 한 변수에 두 개의 데이터타입의 속성을 동시에 지정할 때 사용
    interface I1 {
        a: string;
    }
    interface I2 {
        b: number;
    }

    let implement: I1 & I2 = {
        a: 'str',
        b: 10
    }

    //# 4. 연산자 
    //? 비교 연산 중 ==, ===(, !=, !===)
    //? == : 데이터타입은 비교하지 않음
    const str1: any = '10';
    const num1: any = 10;
    const flag1 = str1 == num1;
    console.log(flag1);

    //? === : 데이터타입까지 모두 비교함
    const flag2 = str1 === num1;
    console.log(flag2);

    //# 5. if 
    //? if문의 조건
    //? ES6 와 TS에서는 false, '', 0, null, undefined 를 모두 false로 받고 나머지는 모두 true
    const emptyArray: null = null;
    if (!emptyArray) console.log('a');

    //# 6. for 
    //? foreach 반복문
    //? Java -> for(요소데이터타입 변수명: 반복해서접근할배열) {}
    //? TS   -> for(const 변수명 of 반복해서접근할배열) {}
    const numberArray = [1, 2, 3];
    for (const item of numberArray) {
        console.log(item);
    }

    //# 7. interface 
    //? TS -> interface를 데이터 타입형태로 사용
    interface IExample {
        a: string;
        b: number;
        c: boolean;
    }
    const object1: IExample = { a: 'a', b: 1, c: true };

    //! 객체형의 데이터타입을 지정할 때는 3가지 방법을 쓸 수 있음
    //^ 1. interface 사용
    //^ 2. class 사용
    class Example {
        a: string;
        b: number;
        c: boolean;

        constructor(a: string, b: number, c: boolean) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    const object2: IExample = new Example('a', 1, true);
    const object3: Example =  { a: 'a', b: 1, c: true };
    //^ 3. type 사용
    type TExample = {
        d: string,
        e: number,
        f: boolean
    }
    const object4: TExample = { d: 'a', e: 1, f: true };
    // const object5: TExample = new Example('a', 1, true);

    //# 8. 삼항 연산자와 Spread 연산자, 비구조화 할당 
    //? 삼항 연산자
    //? 조건 ? 참일때 결과값 : 거짓일때 결과값
    const result = num > 0 ? '양수' : '양수가 아님';
    console.log(result);

    //? 비구조화 할당
    //? object 타입(객체와 배열)의 요소를 하나씩 직접 꺼내서 사용할 수 있도록 하는 것 
    // const { a, b, c } = object1;
    // console.log(a, b, c);
    // const [ a1, b1, c1 ] = numberArray;
    // console.log(a1, b1, c1);

    //? Spread 연산자
    //? ...객체
    //? 1. 비구조화 할당에 쓰일 때는 직접 뽑은 요소를 제외한 나머지 요소를 하나의 묶음으로 묶어줌
    const { a, ...spread1 } = object1;
    console.log(a);
    console.log(spread1);

    //? 2. 새로운 객체를 생성할 때 가지고 있는 객체를 분해해서 요소로 추가
    const example1 = { a1: 'a', object1 };
    console.log(example1);
    const example2 = { a1: 'a', ...object1 };
    console.log(example2);

    let state = { email: "email", password: "password", passwordCheck: "passwordCheck" };
    state = { ...state, email: "이메일" };
    // state = { email: "email", password: "password", passwordCheck: "passwordCheck", email: "이메일" };
    console.log(state);

    //# 9. Enum 
    //? Enumerated Type: 열거형 타입
    enum ENUMERATED {
        APPLE = 'apple',
        BANANA = 'banana',
        CAROT = 'carot'
    }

    const fruit = ENUMERATED.APPLE;
    console.log(fruit);
    // let fruit2: ENUMERATED = 'apple';

  return (
    <div>index</div>
  )
}
