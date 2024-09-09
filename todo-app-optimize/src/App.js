import TodoInsert from "./components/TodoInsert";
import TodoTemplate from "./components/TodoTemplate";
import TodoList from "./components/TodoList";
import {useRef, useCallback, useReducer} from 'react';

const createBulk = () => {
  const todoArray = [];

  for(let i = 1; i <= 10000; i++) {
    const todo = {
      id: i,
      text: `할 일 ${i}`,
      checked: false
    }

    todoArray.push(todo);
  }

  return todoArray;
}

const reducer = (state, action) => {
  switch(action.type) {
    case 'INSERT':
      return state.concat(action.todo);
    case 'REMOVE':
      return state.filter(todo => todo.id !== action.id);
    case 'TOGGLE':
      return state.map(todo => 
        todo.id === action.id
        ? {...todo, checked: !todo.checked}
        : todo
      );
  }
}

function App() {
  const [todos, dispatch] = useReducer(reducer, undefined, createBulk);

  const todoId = useRef(10001);

  // 할 일을 추가하는 메소드
  const addTodo = useCallback((text) => {
    const newTodo = {
      id: todoId.current,
      text: text,
      checked: false,
    }
    // 최적화 3: useReducer를 이용한 최적화
    dispatch({type: 'INSERT', todo: newTodo});

    todoId.current += 1;
  }, [todos]);

  const removeTodo = useCallback((id) => {
    // 최적화 3: useReducer를 이용한 최적화
    dispatch({type: 'REMOVE', id: id});
  }, [todos]);

  const changeChecked = useCallback((id) => {
    // 최적화 3: useReducer를 이용한 최적화
      dispatch({type : 'TOGGLE', 'id':id});
    
  }, [todos]);

  return (
    <TodoTemplate>
      <TodoInsert addTodo={addTodo}/>
      <TodoList todos={todos} removeTodo={removeTodo} changeChecked={changeChecked}/>
    </TodoTemplate>
  );
}

export default App;
