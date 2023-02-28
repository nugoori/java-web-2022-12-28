import { Avatar, IconButton, Typography } from '@mui/material'
import { Box } from '@mui/system'
import React from 'react'

import EditOutlinedIcon from '@mui/icons-material/EditOutlined';
import { useUserStore } from 'src/stores';
import { useNavigate } from 'react-router-dom';

export default function MyPageHead() {

    const { user, resetUser } = useUserStore();
    const navigator = useNavigate();

    const onLogOutHandler = () => {
        resetUser();
        navigator('/');
        alert('로그아웃 되었습니다.');
    }

  return (
    <Box>
        <Box sx={{ p: '40px 120px', display: 'flex'  }}>
        <Box>
            <IconButton onClick={onLogOutHandler}>
                <Avatar sx={{ height: '120px', width: '120px' }}alt={user?.nickName} src={user?.profile} />
            </IconButton>
        </Box>

        <Box sx={{ ml: '25px', display: 'flex', flexDirection: 'column', justifyContent: 'center'}}>
        <Box sx={{ display: 'flex', alignItems: 'center' }}>
            <Typography sx={{ fontSize: '24px', fontWeight: 500, color: 'rgba(0, 0, 0, 0.7)'}}>{user?.nickName}</Typography>
            <IconButton sx={{ mr: '10px'}}>
                <EditOutlinedIcon />
            </IconButton>
        </Box>
        <Typography sx={{ fontSize: '16px', fontWeight: 500, color: 'rgba(0, 0, 0, 0.7)'}}>{user?.email}</Typography>
        </Box>
    </Box>
    </Box>
  )
}
