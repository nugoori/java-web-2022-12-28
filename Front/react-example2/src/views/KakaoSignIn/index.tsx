import { Alert } from "@mui/material";
import React, { useState } from "react";

import "./style.css";

export default function KakaoSignIn() {
  const [email, setEmail] = useState<string>("");

  return (
    <div className="kakao-container">
      {/* 로그인 폼 레이아웃 */}
      <div className="kakao-login-form">
        {/* 로고 레이아웃 */}
        <div className="kakao-logo">
          <div className="kakao-logo-img"></div>
        </div>
        {/* 로그인 레이아웃 */}
        <div className="kakao-login">
          {/* 인풋 레이아웃 */}
          <div className="kakao-input-layout">
            {/* 아이디 인풋 */}
            <div className="kakao-input-box">
              <input
                className="kakao-input"
                type="text"
                placeholder="카카오메일 아이디, 이메일, 전화번호"
                onChange={(event) => setEmail(event.target.value)}
              />
            </div>
            { email && (
              <Alert severity="info">
                카카오 메일이 있다면 메일 아이디만 입력해 보세요.
              </Alert>
            ) }
            {/* 비밀번호 인풋 */}
            <div className="kakao-input-box">
              <input
                className="kakao-input"
                type="password"
                placeholder="비밀번호"
              />
            </div>
            {/* 로그인 상태 유지 인풋 */}
            <div className="kakao-checkbox-box">
              <input className="kakao-checkbox" type="checkbox" />
              {" 로그인 상태 유지"}
            </div>
          </div>
          {/* 버튼 레이아웃 */}
          <div className="kakao-button-layout">
            {/* 로그인 버튼 */}
            <button type="button" className="kakao-login-button">
              로그인
            </button>
            <div className="kakao-divider"></div>
            {/* QR코드 로그인 버튼 */}
            <button type="button" className="kakao-qr-button">
              QR코드 로그인
            </button>
          </div>
          {/* 링크 레이아웃 */}
          <div className="kakao-link-layout">
            {/* 회원가입 링크 */}
            <a
              className="kakao-link"
              href="https://accounts.kakao.com/weblogin/create_account?app_type=web&continue=https%3A%2F%2Flogins.daum.net%2Faccounts%2Fksso.do%3Frescue%3Dtrue%26url%3Dhttps%253A%252F%252Fwww.daum.net&lang=ko"
            >
              회원가입
            </a>
            {/* 정보 찾기 링크 */}
            <a
              className="kakao-link"
              href="https://accounts.kakao.com/weblogin/find_password?app_type=web&continue=https%3A%2F%2Flogins.daum.net%2Faccounts%2Fksso.do%3Frescue%3Dtrue%26url%3Dhttps%253A%252F%252Fwww.daum.net&lang=ko"
            >
              정보 찾기
            </a>
          </div>
        </div>
      </div>
    </div>
  );
}
