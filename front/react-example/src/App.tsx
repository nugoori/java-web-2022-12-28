import { useState } from "react";
import KakaoSignIn from "./views/KakaoSignIn";
import NaverSignIn from "./views/NaverSignIn";

import { Link, Route, Routes } from "react-router-dom";

import './App.css';
import MenuAppBar from "./components/MenuAppBar";
import Es6Typescript from "./views/Es6TypeScript";
import JsxTsx from "./views/JsxTsx";
import { VIEW } from "./enums";
import Hook from "./views/Hook";
import Mui from "./views/Mui";
import RouterView from "./views/RouterView";
import { Typography } from "@mui/material";

export default function App() {
  const [view, setView] = useState<VIEW>(VIEW.NAVER);
  return (
    <div>
      <MenuAppBar />
      <div>
        {/* {view === 'naverSignIn' && (<NaverSignIn />)} */}
        {/*
        //# 삼항 비교 연산자
        //? 조건에 따라서 참일때의 결과값과 거짓일때의 결과값을 지정해서 
        //? 해당하는 경우의 값을 반환
        //? 조건 ? 참일 때의 결과값 : 거짓일 때의 결과값
        */}
        {/* if(조건) {} else { if(조건) {} else {} } */}
        {/*
         //^ <></> : 아무런 의미가 없는 빈 태그
        */}
        <Routes>
          <Route path={VIEW.NAVER} element={(<NaverSignIn />)} />
          <Route path={VIEW.KAKAO} element={(<KakaoSignIn />)} />
          <Route path={VIEW.TYPESCRIPT} element={(<Es6Typescript />)} />
          <Route path={VIEW.TSX} element={(<JsxTsx />)} />
          <Route path={VIEW.MUI} element={(<Mui />)} />
          <Route path={'router'} element={(<RouterView />)} />
          <Route path={'router/:pathValue'} element={(<RouterView />)} />
          <Route path='*' element={(<Typography variant="h3">404</Typography>)} />
        </Routes>
        { /*
          view === VIEW.NAVER ? (<NaverSignIn />) : 
          view === VIEW.KAKAO ? (<KakaoSignIn />) : 
          view === VIEW.TYPESCRIPT ? (<Es6Typescript />) : 
          view === VIEW.TSX ? (<JsxTsx />) : 
          view === VIEW.HOOK ? (<Hook />) : 
          view === VIEW.MUI ? (<Mui />) : 
          view === VIEW.ROUTER ? (<RouterView />) : (<></>) 
        */}
      </div>
    </div>
  );
}
