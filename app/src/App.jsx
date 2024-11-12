import './App.css'
import SingleImageUploader from "./components/singleImageUploader/SingleImageUploader.jsx";
import Home from "./components/Home.jsx";
import {Route, Routes} from "react-router-dom";
import ArticleWriter from "./components/article/writer/ArticleWriter.jsx";

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
    </Routes>
  )
}

export default App
