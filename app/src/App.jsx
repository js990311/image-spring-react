import './App.css'
import SingleImageUploader from "./components/singleImageUploader/SingleImageUploader.jsx";
import Home from "./components/Home.jsx";
import {Route, Routes} from "react-router-dom";

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
    </Routes>
  )
}

export default App
