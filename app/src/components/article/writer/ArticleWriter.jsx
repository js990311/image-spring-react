import {useState} from "react";
import InputFile from "../../input/InputFile.jsx";

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
                                <li>
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