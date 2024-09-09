import {useState, useCallback} from 'react';
import Categories from './components/Categories';
import NewsList from './components/NewsList';

function App() {
  const [category, setCategory] = useState('all');
  const changeCategory = useCallback((cate) => {
    setCategory(() => cate);
  }, []);
  return (
    <>
      <Categories category={category} changeCategory={changeCategory}/>
      <NewsList/>
    </>
  );
}

export default App;
