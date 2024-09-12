import React, {useCallback, useEffect} from 'react';
import TodoListItem from './TodoListItem';
import '../scss/TodoList.scss';
import { useDispatch, useSelector } from 'react-redux';
import { getTodos } from '../apis/todoApis';

const TodoList = () => {
  // useSelector로 store에 저장되어 있는 상태변수 중에 원하는 상태변수를 선택한다.
  // state에는 store.js에 지정한 ReducerRoot 객체가 저장되어 있다.
  const todos = useSelector(state => state.todoSlice.todos);
  const member = useSelector(state => state.memberSlice);
  // useDispatch로 dispatch 메소드 생성
  const dispatch = useDispatch();

  useEffect(() => {
    alert(`${member.username}님 환영합니다.`);
    dispatch(getTodos());
  }, []);

  return (
    <div className='TodoList'>
        {todos && todos.map(todo => 
            <TodoListItem key={todo.id} todo={todo}/>
        )}
    </div>
  );
};

export default TodoList;