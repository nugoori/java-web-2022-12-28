//? 각종 일반 함수 관리

// 페이지네이션 함수
export const getPageCount = (list: any[], count: number) => 
    Math.floor((list.length - 1) / count ) + 1;

