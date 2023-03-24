import React from "react";

//? Props - Properties
interface DateProps {
  placeholder: string;
}

function DateInputGroup({ placeholder }: DateProps) {
  return (
    <div className="flex-1">
      <input
        className="input-middle-style"
        type="number"
        placeholder={placeholder}
      />
    </div>
  );
}

function MonthSelectGroup() {
    //# Typescript에서 배열 선언 및 초기화는 '[]'로 가능
    const months: number[] = [];
    for (let i = 1; i <= 12; i++)
        months.push(i);

    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
  return (
    <div className="flex-1">
      {/* select */}
      <select className="input-middle-style">
        <option>월</option>
        {months.map((month) => {
          return (<option>{month}</option>)
        })}
      </select>
    </div>
  );
}

//! 함수형 컴포넌트의 첫글자는 필수로 대문자이어야 함
export default function BirthInputGroup() {
  return (
    <div className="content">
      <div className="input-label">생년월일</div>
      <div className="flex">
        {/* style의 display 요소를 inline으로 적용해서 inline 형식으로 변경 */}
        <DateInputGroup placeholder="년 (4자리)" />
        <MonthSelectGroup />
        <DateInputGroup placeholder="일" />
      </div>
    </div>
  );
}
