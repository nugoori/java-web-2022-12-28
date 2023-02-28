import React, { useEffect, useState } from 'react'
import { Box, Grid, Pagination, Typography } from '@mui/material'
import { Stack } from '@mui/system'
import { useParams } from 'react-router-dom'
import PopularCard from 'src/components/PopularCard'
import { IPreviewItem } from 'src/interfaces'
import { BOARD_LIST } from 'src/mock'
import BoardListItem from 'src/components/PreviewCard/BoardListItem'
import { getPageCount } from 'src/utils'
import { usePagingHook } from 'src/hooks'

export default function SearchView() {

    const { content } = useParams();
    const { onPageHandler, COUNT, viewList, pageNumber, boardList, setBoardList } = usePagingHook(5);

    // const COUNT = 5;

    // const [ boardList, setBoardList ] = useState<IPreviewItem[]>([]);
    // const [ viewList, setViewList ] = useState<IPreviewItem[]>([]);
    // const [ pageNumber, setPageNumber ] = useState<number>(1);

    // const onPageHandler = (page: number) => {
    //     setPageNumber(page);

    //     const tmpList: IPreviewItem[] = [];
    //     const startIndex = COUNT * (page - 1) ;
    //     const endIndex = COUNT * page - 1;

    //     for (let index = startIndex; index <= endIndex; index++) {
    //         if (boardList.length <= index) break;
    //         tmpList.push(boardList[index]);       
    //     }
    //     setViewList(tmpList)
    // }

    useEffect(() => {
        //# array.filter(요소 => 조건)
        //? 특정한 조건에 부합하는 요소만 모아서 새로운 배열로 만들어 반환하는 메서드
        //# string.includes(검색할 문자열)
        //? 해당 문자열에서 검색한 문자열이 존재한다면 true 아니면 false을 반환하는 메서드
        const tmp = BOARD_LIST.filter((board) => board.boardTitle.includes(content as string))
        setBoardList(tmp);
    }, [content]);

    // useEffect(() => {
    //     onPageHandler(pageNumber);
    // },[boardList])

  return (
    <Box sx={{ p: '40px 120px', backgroundColor: 'rgba(0, 0, 0, 0.05)'}}>
        <Box sx={{ fontSize: '24px', fontWeight: 500 }}>
            <Box component='strong' >'{content}' </Box>
            <Typography component='span' sx={{ fontSize: '24px', fontWeight: 500, opacity: 0.7 }}>에 대한 검색결과 입니다.</Typography>
            <Box component="strong"> ({boardList.length})</Box>
        </Box>
        <Box sx={{ pt: '20px', pb: '80px' }}>
            <Grid container spacing={3}>
                <Grid item sm={12} md={8}>
                    <Stack spacing={2}>
                        {viewList.length === 0 ? (<Box sx={{ height: '416px', display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
                            <Typography sx={{ fontSize: '24px', fontWeight: 500, color: 'rgba(0, 0, 0, 0.4)'}}>검색 결과가 없습니다.</Typography></Box>) : viewList.map((boardItem) => (<BoardListItem item={boardItem as IPreviewItem}/>))}
                    </Stack>
                </Grid>
                <Grid item sm={12} md={4}>
                    <PopularCard title='연관검색어'/>
                </Grid>
            </Grid>
        </Box>
        <Box sx={{ display: 'flex', justifyContent: 'center' }}>
            <Pagination page={pageNumber} count={getPageCount(boardList, COUNT)} onChange={(event, value) => {onPageHandler(value)}}/>
        </Box>
    </Box>
  )
}
