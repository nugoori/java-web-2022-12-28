import React from 'react'
import { Avatar, Box, Divider, Typography } from '@mui/material'
import { ICommentItem } from 'src/interfaces'

interface Props {
  item: ICommentItem;
}

export default function CommentListItem({ item }: Props) {

  const dateGap = Date.now() - Date.parse(item.commentDateTime);
  const before = Math.floor(dateGap / (1000 * 60))

  return (
    <Box>
        <Box>
            <Box sx={{ mb: '8px', display: 'flex', alignItems: 'center' }}>
                <Avatar sx={{ height: '32px', width: '32px', mr: '8px'}} src={item.commentUserProfile}/>
                <Typography sx={{ fontSize: '16px', fontWeight: 500, color:'rgba(0, 0, 0, 0.7)'}}>{item.commentUserNickName}</Typography>
                <Divider sx={{ mr: '8px', ml: '8px' }} orientation='vertical' variant='middle' flexItem />
                <Typography sx={{ fontSize: '16px', fontWeight: 400, color: 'rgba(0, 0, 0, 0.4)'}}>{before}분 전</Typography>
            </Box>
            <Typography sx={{ fontSize: '18px', fontWeight: 500, lineHeight: '150%', color: 'rgba(0, 0, 0, 0.7)' }}>{item.commentContent}</Typography>
            </Box>
    </Box>
  )
}
