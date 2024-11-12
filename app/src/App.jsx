import './App.css'
import SingleImageUploader from "./components/singleImageUploader/SingleImageUploader.jsx";
import Home from "./components/Home.jsx";
import {Route, Routes} from "react-router-dom";
import ArticleWriter from "./components/article/writer/ArticleWriter.jsx";
import Article from "./components/article/Article.jsx";

function App() {
  return (
    <Routes>
        <Route
            path={""}
            element={<Home />}
        />
        <Route
            path={"upload-single-image"}
            element={<SingleImageUploader />}
        />
        <Route
            path={"article/create"}
            element={<ArticleWriter/>}
        />
        <Route
            path={"article/:articleId"}
            element={<Article />}
        />
    </Routes>
  )
}

export default App
