import { Box } from '@mui/material'
import React from 'react'
import MainContents from './MainContents'
import MainHead from './MainHead'

export default function Main() {
  return (
    <Box sx={{ }}>
        <MainHead />
        <MainContents />
    </Box>
  )
}
