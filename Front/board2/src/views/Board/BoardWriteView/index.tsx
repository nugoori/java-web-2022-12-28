import { Box, Divider, Fab, IconButton, Input } from '@mui/material'
import ImageOutlinedIcon from '@mui/icons-material/ImageOutlined';
import CreateIcon from '@mui/icons-material/Create';
import { useState } from 'react'
import { useNavigate } from 'react-router-dom';

export default function BoardWriteView() {

    const navigator = useNavigate();

    const [ boardTitle, setBoardTitle] = useState<string>('');
    const [ boardContent, setBoardContent] = useState<string>('');
    const onWriteHandler = () => {
        //? title, content 값이 존재하는지 검증
        if (!boardTitle.trim() || !boardContent.trim()) {
            alert('모든 내용을 입력해주세요.')
            return;
        }
        //? 존재하면 작성
        navigator('/myPage');
    }

    //# User table
    //^ userEmail VARCHAR(45) PK(여야 넘겨줄 수 있음)

    //# Board table
    //^ boardNumber INT AI PK  
    //^ boardWTitle TEXT NotNULL
    //^ boardContent TEXT NN
    //^ writeDate DATETIME NN
    //^ writerEmail VARCHAR(45) FK NN
    //^ likeCount INT default 0
    //^ commentCount INT default 0
    //^ viewCount INT default 0

    //? INSERT INTO Board(boardTitle, boardContent, writeDate, writerEmail)
    //?           VALUES (     ?,          ?,          now(),       ?     )
    //? Back end로 boardTitle, boardContent, writerEmail을 넘겨주면 됨

  return (
    <Box sx={{ p: '0px 198px', backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
        <Box sx={{ p: '100px 24px', backgroundColor: '#ffffff' }}>
            <Input fullWidth disableUnderline placeholder='제목을 입력하세요.' 
            sx={{ fontSize: '32px', fontWeight: 500, color: 'rgba(0, 0, 0, 0.4)' }} onChange={(event) => setBoardTitle(event.target.value)}/>
            <Divider sx={{ m: '40px 0px'}}/>
            <Box sx={{ display: 'flex', alignItems: 'start'}} >
                <Input fullWidth disableUnderline multiline minRows={20} placeholder='본문을 작성해주세요.' 
                sx={{ fontSize: '18px', fontWeight: 500, lineHeight: '150%' }} onChange={(event) => setBoardContent(event.target.value)}/>
                <IconButton>
                    <ImageOutlinedIcon />
                </IconButton>
            </Box>
        </Box>
        <Fab sx={{ position: 'fixed', bottom: '200px', right: '228px', backgroundColor: 'rgba(0, 0, 0, 0.4)'}} onClick={onWriteHandler} >
            <CreateIcon />
        </Fab>
    </Box>  
  )
}
