import React, {useCallback} from 'react';
import { MdCheckBoxOutlineBlank, MdRemoveCircleOutline } from 'react-icons/md';
import '../scss/TodoListItem.scss';

const TodoListItem = ({todo, deleteTodo}) => {

  return (
    <div className='TodoListItem'>
        <div className='checkbox'>
            <MdCheckBoxOutlineBlank/>
            <div className='text'>{todo.text}</div>
        </div>
        <div className='remove' onClick={() => deleteTodo(todo.id)}>
            <MdRemoveCircleOutline/>
        </div>
    </div>
  );
};

export default TodoListItem;