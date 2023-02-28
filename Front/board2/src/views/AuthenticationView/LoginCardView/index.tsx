import { Dispatch, SetStateAction, useState } from 'react'
import { Box, TextField, Typography, FormControl, InputLabel, Input, InputAdornment, IconButton, Button } from '@mui/material';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import Visibility from '@mui/icons-material/Visibility';
import { EnhancedEncryptionTwoTone } from '@mui/icons-material';

import { USER } from 'src/mock';
import { useUserStore } from 'src/stores';
import { useNavigate } from 'react-router-dom';
import useStore from 'src/stores/user.store';


interface Props {
    setLoginView: Dispatch<SetStateAction<boolean>>
}

export default function LoginCardView({ setLoginView }: Props) {

  const [email, setEmail] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const [showPassword, setShowPassword] = useState<boolean>(false);

  const { setUser } = useStore();
  const navigator = useNavigate();

  const onLoginHandler = () => {
    //? email 입력했는지 검증, password 입력했는지 검증
    if (!email.trim() || !password) {
        alert('모든 값을 입력해주세요.');
        return;
    }
    //? USER mock 데이터의 email과 password가 입력받은 email과 password와 일치하는지 검증
    if (USER.email !== email || USER.password !== password ) {
        alert('로그인 정보가 일치하지 않습니다.');
        return;
    }

    //? 로그인 처리
    //? 쿠키에 로그인 데이터(Token) 보관
    //? 스토어에 유저 데이터 보관
    setUser(USER);
    navigator('/');
  }

  return (
    <Box display='flex' sx={{height: '100%', flexDirection: 'column', justifyContent: 'space-between'}}>
        <Box>
            <Typography variant='h5' fontWeight='900'>로그인</Typography>
            <TextField sx={{mt: '40px'}} fullWidth label="이메일 주소" variant="standard" onChange={(event) => setEmail(event?.target.value)}/>
            <FormControl fullWidth variant="standard" sx={{ mt: '40px' }}>
                <InputLabel>비밀번호</InputLabel>
                <Input
                    type={showPassword ? 'text' : 'password'}
                    endAdornment={
                    <InputAdornment position="end">
                        <IconButton
                        onClick={() => setShowPassword(!showPassword)}
                        >
                        {showPassword ? <VisibilityOff /> : <Visibility />}
                        </IconButton>
                    </InputAdornment>
                    }
                    onChange={(event) => setPassword(event.target.value)}
                />
            </FormControl>
        </Box>
        <Box>
            <Button sx={{mb: '20px'}} fullWidth variant="contained" size='large' onClick={onLoginHandler}>로그인</Button>
            <Typography textAlign={'center'}>신규사용자 이신가요? 
                <Typography component='span' fontWeight={900} onClick={() => setLoginView(false)}> 회원가입</Typography>
            </Typography>
        </Box>
    </Box>
  )
}


