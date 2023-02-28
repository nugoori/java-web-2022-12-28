import { Button, Card, Grid, Pagination, Typography, Box, CardActionArea, Stack } from '@mui/material'
import React, { useEffect } from 'react'
import CreateIcon from '@mui/icons-material/Create';

import { usePagingHook } from 'src/hooks';
import { BOARD_LIST } from 'src/mock';
import { useUserStore } from 'src/stores';
import BoardListItem from 'src/components/PreviewCard/BoardListItem';
import { getPageCount } from 'src/utils';
import { useNavigate } from 'react-router-dom';
import BoardWriteView from 'src/views/Board/BoardWriteView';
import { IPreviewItem } from 'src/interfaces';

export default function MyPageContents() {

    const { boardList, viewList ,pageNumber, setBoardList ,onPageHandler, COUNT } = usePagingHook(5);
    //? 로그인 한 상태일 때 유저 정보를 가져올 수 있도록 store에서 user상태를 가져옴
    const { user } = useUserStore();
    const navigator = useNavigate();

    useEffect(() => {
        //? 로그인이 되어있지 않으면 로그인 페이지로 이동 ( 로그인확인 : 쿠키, )
        // if ( !user ) {
        //     alert('로그인이 필요한 작업입니다.');
        //     navigator('/auth');
        //     return;
        // }
        //? BOARD_LIST (전체 게시물 리스트)에서 작성자의 nickName이
        //? 로그인한 nickName과 일치하는 게시물만 필터링해서 '기준'이되는 새로운 리스트를 생성
        const tmp = BOARD_LIST.filter((board) => board.writerNickname === user?.nickName)
        //? 기준이 되는 새 리스트를 boardList 상태에 저장
        setBoardList(tmp);
    }, [])

  return (
    <Box sx={{ p: '40px 120px', backgroundColor: 'rgba(0, 0, 0, 0.05)'}}>
        <Box>
            <Typography sx={{ fontSize: '24px', fontWeight: 500 }}>내 게시물 {boardList.length}</Typography>
        </Box>
        <Box sx={{ mt: '20px', mb: '80px'}}>
            <Grid container spacing={3}>
                <Grid item sm={12} md={8}>
                    <Stack spacing={2}>
                        {viewList.map((boardItem) => (<BoardListItem item={ boardItem as IPreviewItem } />)) }       
                    </Stack>
                </Grid>
                <Grid item sm={12} md={4}>
                   <Card variant='outlined' >
                        <CardActionArea sx={{ p: '25px 0px', display: 'flex', justifyContent: 'center'}} onClick={() => navigator('/board/write')}>
                            <CreateIcon sx={{ mr: '6px' }}/>
                            <Typography sx={{ fontSize: '18px', fontWeight: 500 }}>글쓰기</Typography>
                        </CardActionArea>
                   </Card>
                </Grid>
            </Grid>
        </Box>
        <Box sx={{ display: 'flex', justifyContent: 'center' }}>
            <Pagination page={pageNumber} count={getPageCount(boardList, COUNT)} onChange={(event, value) => onPageHandler(value)}/>
        </Box>
    </Box>
  )
}
