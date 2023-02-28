import { Box, Card, Chip, Typography } from '@mui/material'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { POPULAR_LIST } from 'src/mock';

interface Props {
  title: string;
};

export default function PopularCard({ title }: Props) {

  const [popularList, setPopularList] = useState<string[]>([]);
  const navigator = useNavigate();

  useEffect(() => {
    // setPopularList(POPULAR_LIST)
  }, [])
  return (
    <Card variant='outlined' sx={{ p: '24px 12px 26px 24px' }}>
        <Typography sx={{ fonstSize: '24px', fontWeight: '500' }}>{title}</Typography>
        <Box sx={{ mt: '24px' }}>
          {popularList.length === 0 ? 
          (<Box sx={{ height: '344px', display: 'flex', justifyContent: 'center', alignItems: 'center'}}><Typography sx={{ fontSize: '24px', fontWeight: 500, color: 'rgba(0, 0, 0, 0.4'}}>검색 결과가 없습니다.</Typography></Box>) : 
          popularList.map((popular) => (
            <Chip label={popular} variant='outlined' onClick={(event) => navigator(`/board/search/${popular}`)} sx={{ fontSize: '14px', fontWeight: '500', mr: '12px', mb: '12px' }}/>
          ))}   
        </Box>
    </Card>
  )
}
