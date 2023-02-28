import { Box, Card, Grid, Typography } from '@mui/material'
import { useEffect, useState } from 'react'
import PreviewCard from 'src/components/PreviewCard'
import { IPreviewItem } from 'src/interfaces';

import { TOP3 } from 'src/mock';

export default function MainHead() {

    const [top3List, setTop3List] = useState<IPreviewItem[]>([]);

    useEffect(() => {
        setTop3List(TOP3);
    }, [])  // state 사용

  return (
    <Box sx={{ pb: '40px', pl: '120px', pr: '120px' }}>
        {/* 점보트론 텍스트  */}
        <Box sx={{ pt: '80px', pb: '32px', textAlign: 'center'}}>
            <Typography sx={{ fontSize: '40px', fontWeight: '400' }}>Hoons Board에서</Typography>
            <Typography sx={{ fontSize: '40px', fontWeight: '400' }}>다양한 이야기를 나눠보세요.</Typography>
        </Box>
        {/* 주간 TOP3 게시물 */}
        <Box>
            <Typography sx={{ fontSize: '24px', fontWeight: '400', pt: '24px', textAlign: 'center' }}>주간 TOP 3 게시물</Typography>
            <Grid container spacing={3} >
                {top3List.map((item) => (
                    <Grid item sm={12} md={4}>
                        <PreviewCard previewItem={item} />
                    </Grid>
                ))}
            </Grid>
        </Box>
    </Box>
  )
}
