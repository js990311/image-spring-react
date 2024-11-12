import {Link} from "react-router-dom";

const Home = () => {
    return (
        <div>
            <h1>홈페이지</h1>
            <Link to={"/upload-single-image"}>이미지 하나 올리기</Link>
            <Link to={"/article/create"}>게시글 작성하기</Link>
        </div>
    )
}

export default Home;