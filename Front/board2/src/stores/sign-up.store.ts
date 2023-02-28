//# Java Class or React의 컴포넌트의 파일명은 UpperCamelCase가 아니면 인식X
//# Typescript의 경우 특별한 파일의 네이밍 규칙이 지정되어있지 않기 때문에 필수적으로 Upper.Camel.Class를 사용할 필요가 없음

//# Zustand를 사용하여 스토어 생성
//^ zustand에서 create요소를 import

import { create } from "zustand";

//# Typescript에서 함수의 타입을 지정하는 방법
//? (매개변수명: 매개변수 타입) => 반환타입
interface ISignUpStore {
    email: string;
    password: string;
    passwordCheck: string;
    nickName: string;
    telNumber: string;
    address: string;
    addressDetail: string;
    setEmail: (email: string) => void,
    setPassword: (password: string) => void,
    setPasswordCheck: (passwordCheck: string) => void,
    setNickName: (nickName: string) => void,
    setTelNumber: (telNumber: string) => void,
    setAddress: (address: string) => void,
    setAddressDetail: (addressDetail: string) => void
}

//^ create 메서드를 사용해서 store를 생성
const useStore = create<ISignUpStore>((set) => ({
     //^ 상태변수 선언
     //^ 상태의 이름: 초기화
    email: '',
    password: '',
    passwordCheck: '',
    nickName: '',
    telNumber: '',
    address: '',
    addressDetail: '',
    //^ set메서드 선언
    //? set상태명: (상태명) => set((state) => ({...state, 상태명}))
    setEmail: (email) => set((state) => ({...state, email})),
    setPassword: (password) => set((state) => ({...state, password})),
    setPasswordCheck: (passwordCheck) => set((state) => ({...state, passwordCheck})),
    setNickName: (nickName) => set((state) => ({...state, nickName})),
    setTelNumber: (telNumber) => set((state) => ({...state, telNumber})),
    setAddress: (address) => set((state) => ({...state, address})),
    setAddressDetail: (addressDetail) => set((state) => ({...state, addressDetail})),
}))

export default useStore;

//# 일반적인 상태(state)를 선언하는 코드
//? const [상태, set메서드] = useState<데이터타입>(초기화값);

//# Zustand를 사용해서 상태를 선언하는 코드
//? const useStore = create<데이터타입>((set) => ({
//?     상태명: 초기화값;
//?     set메서드(상태를 변경하는 메서드): (파라미터) => set((state) => ({...state, 파라미터})),
//?     ...,
//? }));

//^ 1. const useStore = create((set) => ({ ... }))
//^    :== useState와 동일
//^ 2. 상태명: 초기화값,
//^    :== [상태명, ...] = ...(초기화값)
//^ 3. set메서드: (파라미터) => set((state) => ({..state, 파라미터}))
//^    :== [..., set메서드]

//# spread연산자
//? const {요소1, 요소2, ...} = 객체;
//? ...객체 : 객체에서 지정한 요소를 제외하고 남은 요소를 객체로 묶음 처리 함
//? const {요소1, ...뮦음객체명} = 객체;

// const mainObj ={
//     a: 0,
//     b: 1,
//     c: 2,
//     d: 3,
// }

// const {a, ...subObj} = mainObj;
// //? subObj = { b: 1, c: 2, d: 3};

// const setMainObjA = (a: number) => {
//     // mainObj.a = a;
//     const modifiedObj = {...mainObj, a};
//     return modifiedObj;
// }

// const tmpObj = setMainObjA(10); // => {a: 10, b: 1, c: 2, d: 3} 으로 !복사!하여 변경

