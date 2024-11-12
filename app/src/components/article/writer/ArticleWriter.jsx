import {useState} from "react";
import InputFile from "../../input/InputFile.jsx";
import axios from "axios";
import {useNavigate} from "react-router-dom";

const ArticleWriter = () => {
    const [files, setFiles] = useState([
        null
    ]);

    const [content, setContent ] = useState('');
    const nav = useNavigate();

    const onChangeFiles = (id, file) => {
        const alterFiles = files.map(
            (val, idx) => {
                if(idx === id){
                    return file;
                }else {
                    return val;
                }
            }
        )
        setFiles(alterFiles);
    }
    
    const onAddFile = () => {
        setFiles([
            ...files, null
        ])
    }

    const onDeleteFile = (id) => {
        setFiles(files.filter(
            (val, idx) => {
                return idx !== id;
            }
        ))
    }

    const onPost = async () => {
        const formData = new FormData();
        files.forEach((file) => {
            if(file) {
                formData.append("files", file);
            }
        })
        formData.append("content", content);

        try {
            const resp = await axios.post(
                "http://localhost:8080/article/create",
                formData,{
                    headers : {
                        "Content-Type": "multipart/form-data",
                    }
                }
            );
            console.log(resp.data);
            nav(`/article/${resp.data.id}`);
        }catch (error){
            console.log(error);
        }

    }

    return (
        <div>
            <div>
                <input 
                    type="text"
                    value={content}
                    onChange={({target}) => {
                        setContent(target.value);
                    }}
                />
            </div>
            <div>
                <ul>
                    {
                        files.map((file, id) =>
                            (
                                <li key={id}>
                                    <InputFile
                                        id = {id}
                                        onChange={onChangeFiles}
                                        onDelete={onDeleteFile}
                                    />
                                </li>
                            )
                        )
                    }

                </ul>
                <button onClick={onAddFile}>
                    첨부파일 추가하기
                </button>
            </div>
            <button onClick={onPost}>제출</button>
        </div>
    )
}

export default ArticleWriter;