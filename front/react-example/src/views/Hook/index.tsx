import { useState, useEffect } from 'react'

//# Hook -> 함수형 컴포넌트에서만 동작 
//? state와 React 기능을 관리하는 메서드

//^ Hook 함수의 규칙
//? 1. 무조건 함수형 컴포넌트 내에서만 호출할 수 있음
//? 2. 무조건 함수형 컴포넌트 최상위단에서만 호출할 수 있음
//? 3. 조건부로 호출할 수 없음 

//# 함수형 컴포넌트 외부에서 Hook 함수를 사용한 경우
//! React Hooks must be called in a React function component or a custom React Hook function
//? 위 에러를 반환
// const [extState, setExtState] = useState<boolean>(false);

export default function Hook() {

    //# 함수형 컴포넌트의 자손 함수에서 사용한 경우
    //! React component names must start with an uppercase letter. 
    //! React Hook names must start with the word "use" 
    //? 위 에러를 반환
    const fn = () => {
        // const [intState, setIntState] = useState<boolean>(false);
    }

    //# 1. useState()
    //? React 컴포넌트 내에서 state를 추적
    //? state를 만들어주는 메서드
    //? import { useState } from 'react';

    //? State 선언 
    //? const [상태명, set메서드] = useState<데이터타입>(초기값);
    //? 여기서 지정한 State가 변경되면 해당 State를 사용하고있는 컴포넌트가 리랜더링됨
    const [state, setState] = useState<boolean>(false);

    //? State를 변경할 때는 state를 상수로 선언하기 때문에 setState로 변경 해줘야함
    let [state2, setState2] = useState<boolean>(false);
    //? 위처럼 state를 변수로 선언하고 해당 변수를 대입연산자로 변경하더라도
    //? 리랜더링 되지 않음 (무조건 set메서드로 변경 해줘야함)

    const [objectState, setObjectState] = useState<number[]>([1])

    const onClickHandler = () => {
        //^ 주의 할 점
        //^ 배열 혹은 객체를 가지고 있는 참조변수의 경우
        //^ 실제 값을 변경하고 다시 set메서드로 적용시켜준다 하더라도
        //^ 참조변수가 가지고 있는 주소는 변경되지 않기 때문에
        //^ state가 변경되었다고 인식하지 못해서
        //^ 랜더링이 다시 되지 않음
        objectState.push(1);

        //^ 새로운 배열 혹은 객체를 생성하여 새로운 주소를 할당한 다음
        //^ 새로운 주소를 가지고 있는 참조 변수로 변경해야 리랜더링이 됨
        const tmp = objectState.map((item) => item);
        setObjectState(tmp);
    }

    const [num, setNum] = useState<number>(1);

    const onPlusHandler = () => {
        //^ 상태를 set메서드로 변경 시키더라도
        //^ 바로 상태가 변경되는 것이 아니라
        //^ 해당 호출 혹은 함수가 종료되고 리랜더링 된 후 변경됨
        setNum(num + 1);

        //^ 그렇기 때문에 아래와 같이 변경 후에 변경한 값으로 작업을 하려고 해도
        //^ 원래 저장되어있는 값으로 작업이 진행됨
        alert(num);
        //! 이런 문제를 해결하는 방법
        //^ 1. 바로 아래의 useEffect 처럼 사용
        //^ 2. 변경 작업을 따로 저장한 후 그 저장한 값으로 작업을 진행하고
        //^    그 값으로 state를 변경
    }

    useEffect(() => {
        // alert(num);
    }, [num]);

    //# 2. useEffect
    //? 특정 상태값이 변경되는지 추적하고 있다가
    //? 변경이 이루어지면 실행할 코드블록

    //? 함수형 컴포넌트 최상위에서 함수를 호출하면
    //? 매 랜더링시 호출됨
    //? 특정 상태가 변경되었을 때만 실행시키는 동작을 수행할 수 없음
    // console.log(objectState);

    //? import { useEffect } = 'react';
    
    //? 호출 방법
    //? useEffect(특정 상태가 변경되었을때 실행되는 함수, 추적할 상태의 배열);
    useEffect(() => {
        console.log(objectState);
    }, [objectState]);

    let loaded = false;

    //^ scope하는 state를 지정하지 않으면
    //^ 해당 함수는 로드시에만 호출 됨
    //^ 단, react 컴포넌트 생명 주기 상
    //^ useEffect는 첫 로드시 두 번 실행됨
    useEffect(() => {
        //! 첫 로드 시 두 번 실행되는 것을 방지하는 방법
        //^ 특정 변수를 지정하여 그 값이 참일 때만 실행하도록 하고
        //^ 실행 후에는 참인 상태를 거짓의 상태로 변경해줌
        if (!loaded) {
            console.log('로드 될때만 실행되는 함수!!');
            loaded = true;
        }
    }, []);

    //^ useEffect에서 scope할 state를 지정할 때 주의!!
    const [flag, setFlag] = useState<boolean>(false);

    //^ useEffect에 scope한 state를 해당 useEffect 내에서
    //^ 변경하는 작업을 진행하면 무한 실행이 됨
    useEffect(() => {
        console.log('이거 뭐야!!!!!');
        // setFlag(!flag);
    }, [flag]);

  return (
    <div>
        <div>{state ? 'true' : 'false'}</div>
        <button onClick={() => setState(!state)}>버튼!</button>
        {objectState.map((num) => (
            <div>{num}</div>
        ))}
        <button onClick={onClickHandler}>Add number!</button>

        <div>{num}</div>
        <button onClick={onPlusHandler}>{'+'}</button>
    </div>
    
  )
}

