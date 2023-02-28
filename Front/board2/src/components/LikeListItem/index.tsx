import React from 'react'
import { Avatar, Box, Typography } from '@mui/material'
import { ILikeUser } from 'src/interfaces'

interface Props {
    likeUser: ILikeUser;
}

export default function LikeListItem({ likeUser }: Props ) {
  return (
    <Box sx={{ display: 'inline-flex', alignItems: 'center', mr: '30px' }} >
        <Box component='img' sx={{ height: '32px', width: '32px', mr: '8px' }} src={likeUser.likeUserProfile}/>
        <Typography  sx={{ fontSize: '16px', fontWeight: 500 }}>{likeUser.likeuserNickName}</Typography>
    </Box>                        
  )
}   
