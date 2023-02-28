//? 인터페이스 관리
export interface IPreviewItem {
    img: string | null;
    writerProfile: string;
    writerNickname: string;
    writeDate: string;
    boardTitle: string;
    boardContent: string;
    likeCount: number;
    commentCount: number;
    viewCount: number;

    boardNumber: number;
}

export interface IUser {
    email: string,
    password: string,
    nickName: string,
    telNumber: string,
    address: string,
    addressDeatil: string,
    profile?: string, // url이 들어가기 때문
}

export interface ILikeUser {
    likeUserProfile: string;
    likeuserNickName: string;
}

export interface ICommentItem {
    commentUserProfile: string;
    commentUserNickName: string;
    commentContent: string;
    commentDateTime: string;
}