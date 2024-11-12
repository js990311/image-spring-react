const InputFile = ({id, onChange, onDelete}) => {

    const onChangeLocal = ({target}) => {
        const file = target.files[0];
        onChange(id, file);
    }

    return (
        <>
            <button onClick={()=>{onDelete(id)}}>X</button>
            <input
                type="file"
                onChange={onChangeLocal}
            />
        </>
    )
}

export default InputFile;