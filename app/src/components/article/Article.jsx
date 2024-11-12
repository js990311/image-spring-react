import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";

const Article = () => {
    const {articleId} = useParams();
    const [article, setArticle] = useState({
        content : '',
        images : []
    });
    const getArticle = async () => {
        try {
            const resp = await axios.get(
                `http://localhost:8080/article/${articleId}`
            );
            console.log(resp);
            setArticle(resp.data);
        }catch (error){
            console.log(error);
        }
    }

    useEffect(() => {
        getArticle();
    }, []);

    return (
        <div>
            <p>{article.content}</p>
            <div>
                {
                    article.images.map(
                        (image) => {
                            return (<img key={image.path}
                                    src={`http://localhost:8080/image/${image.path}`}
                                    alt={`${image.filename}`}
                                />)
                        }
                    )
                }
            </div>
        </div>
    )
}

export default Article;