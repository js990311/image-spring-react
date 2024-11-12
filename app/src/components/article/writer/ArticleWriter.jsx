import {useState} from "react";
import InputFile from "../../input/InputFile.jsx";
import {i} from "vite/dist/node/types.d-aGj9QkWt.js";
import axios from "axios";

const ArticleWriter = () => {
    const [files, setFiles] = useState([
        null
    ]);

    const [content, setContent ] = useState('');

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
        formData.append("files", files);
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
            console.log(resp);
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
        </div>
    )
}

export default ArticleWriter;