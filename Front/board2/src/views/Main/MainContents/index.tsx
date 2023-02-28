import { Box, Card, Grid, Pagination, Stack, Typography } from '@mui/material'
import { useEffect, useState } from 'react';
import PopularCard from 'src/components/PopularCard'
import BoardListItem from 'src/components/PreviewCard/BoardListItem'
import { usePagingHook } from 'src/hooks';
import { IPreviewItem } from 'src/interfaces';
import { BOARD_LIST } from 'src/mock';
import { getPageCount } from 'src/utils';

export default function MainContents() {

  const { onPageHandler, COUNT, viewList, pageNumber, boardList, setBoardList } = usePagingHook(5);

  useEffect(() => {
    setBoardList(BOARD_LIST);
  }, []);

  return (
    <Box sx={{ p: '40px 120px', backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
      <Box >
        <Typography sx={{ fontSize: '24px', fontWeight: '500' }}>최신 게시물</Typography>
      </Box>
      <Box sx={{ pt: '20px', pb: '80px' }}>
        <Grid container spacing={3}>         
          <Grid item sm={12} md={8}>
            <Stack spacing={2}>
              {viewList.map((boardItem) => (<BoardListItem item={boardItem as IPreviewItem} />))}     
            </Stack>         
          </Grid>
          <Grid item sm={12} md={4}>            
            <PopularCard title="인기 검색어"/>
          </Grid>
        </Grid>

      </Box>
      <Box sx={{ display: 'flex', justifyContent: 'center' }}>
        <Pagination page={pageNumber} count={getPageCount(boardList, COUNT)} onChange={(event, value) => onPageHandler(value)}></Pagination>
      </Box>
    </Box>
  );
}
