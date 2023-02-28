import { Box } from '@mui/material'
import React from 'react'
import MyPageContents from './MyPageContents'
import MyPageHead from './MyPageHead'

export default function MyPageView() {
  return (
    <Box>
        <MyPageHead />
        <MyPageContents />
    </Box>
  )
}
