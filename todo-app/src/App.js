import TodoInsert from "./components/TodoInsert";
import TodoTemplate from "./components/TodoTemplate";
import TodoList from "./components/TodoList";
import {useState, useRef, useCallback} from 'react';

import {produce} from 'immer';

function App() {
  const [todos, setTodos] = useState([
    {
      id: 1,
      text: '리액트 공부하기',
      checked: false,
    },
    {
      id: 2,
      text: '자바스크립트 공부하기',
      checked: true,
    },
    {
      id: 3,
      text: 'Spring Boot 공부하기',
      checked: true,
    },
  ]);

  const todoId = useRef(4);

  // 할 일을 추가하는 메소드
  const addTodo = useCallback((text) => {
    const newTodo = {
      id: todoId.current,
      text: text,
      checked: false,
    }

    setTodos(
      todos.concat(newTodo)
    );

    todoId.current += 1;
  }, [todos]);

  // 삭제하는 메소드
  const deleteTodo = useCallback((id)=>{
    setTodos(produce(
      (d) => {
        return d.filter(info=> info.id !== id);
      }
    ));
  }, [todos]);

  return (
    <TodoTemplate>
      <TodoInsert addTodo={addTodo}/>
      <TodoList todos={todos} deleteTodo={deleteTodo}/>
    </TodoTemplate>
  );
}

export default App;
