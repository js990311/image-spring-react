import {useState} from "react";
import axios from "axios";

const SingleImageUploader = () => {
    const [file, setFile] = useState(null);
    const [filePath, setFilePath] = useState('');

    const onChangeFile = ({target}) => {
        const file = target.files[0];
        setFile(file);
    }

    const onUpload = async () => {
        if(!file){
            console.log("파일이 없다");
            return;
        }

        const formData = new FormData();
        formData.append("file", file);

        try {
            const resp = await axios.post(
                "http://localhost:8080/upload-single-image",
                formData,{
                    headers : {
                        "Content-Type": "multipart/form-data",
                    }
                }
            );
            console.log(resp);
            setFilePath(resp.data);
        }catch (error){
            console.log(error);
        }
    }

    return (
        <div>
            <h1>이미지 업로드</h1>
            <input type="file" onChange={onChangeFile}/>
            <button onClick={onUpload}>업로드</button>
            <p>저장된 파일 위치 : <span>{filePath}</span></p>
            {
                filePath !== "" &&
                <img src={`http://localhost:8080/image/${filePath}`} alt="이미지불러오기실패"/>
            }
        </div>
    )
}

export default SingleImageUploader;