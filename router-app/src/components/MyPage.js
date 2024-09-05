import React, {useEffect} from 'react';
import { Navigate, useNavigate } from 'react-router-dom';


const MyPage = () => {
    // 컴포넌트가 표출되는 순간 다른 페이지로 이동하려면 Navigate 컴포넌트를 사용한다.
    const isLogin = false;

    // 방벙 1
    // if(!isLogin)
    //     return <Navigate to='/login'/>

    // 방법 2
    const navi = useNavigate();

    const movePage = (pageUrl) => {
        navi(pageUrl);
    }

    useEffect(() => {
        if(!isLogin)
            navi('/login');
    }, []);
    
  return (
    <div>MyPage</div>
  );
};

export default MyPage;