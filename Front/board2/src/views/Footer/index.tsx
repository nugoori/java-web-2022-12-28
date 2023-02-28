import { Box, IconButton, Typography } from '@mui/material'
import InstagramIcon from '@mui/icons-material/Instagram';
import FacebookIcon from '@mui/icons-material/Facebook';
import React from 'react'

export default function Footer() {
  return (
    <Box sx={{ p: '40px 120px 50px 120px', backgroundColor: '#373737' }}>
        <Box sx={{display: 'flex', justifyContent: 'space-between'}}>
            <Box>
                <Typography sx={{ fontSize: '20px', fontWeight: 400, color: '#ffffff'}}>Hoons Board</Typography>               
            </Box>
            <Box>    
                <Typography component='span' sx={{ fontSize: '12px', fontWeight: 400, color: '#ffffff', mr: '12px'}} >lacls159@gmail.com</Typography>            
                <IconButton>
                    <InstagramIcon sx={{ color: '#ffffff'}} />
                </IconButton>
                <IconButton>
                    <FacebookIcon sx={{ color: '#ffffff'}}/>
                </IconButton>
            </Box>
        </Box>
        <Typography sx={{ fontSize: '12px', fontWeight: 400, color: '#ffffff'}}>Copyright @ 2022 jukoyakki. all Rights Reserced</Typography>
    </Box>
  )
}
