import React from 'react';
import TodoListItem from './TodoListItem';
import '../scss/TodoList.scss';

const TodoList = ({todos, deleteTodo}) => {
  return (
    <div className='TodoList'>
        {/* 반복적으로 작업해주는 부분에는 key값 필요, 없으면 에러 발생 */}
        {todos && todos.map(todo => 
            <TodoListItem key={todo.id} todo={todo} deleteTodo={deleteTodo}/>
        )}
    </div>
  );
};

export default TodoList;