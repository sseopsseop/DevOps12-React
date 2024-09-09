import React from 'react';

// 함수를 Children으로 전달받을 때는
// children를 메소드처럼 사용한다.
const FunctionalChildren = ({children}) => {
  return (
    <div>결과 : {children(5)}</div>
  );
};

export default FunctionalChildren;