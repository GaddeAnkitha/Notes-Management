import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function ViewNote() {
    const { id } = useParams();
    const [note, setNote] = useState(null);

    const getNote = async () => {
        try {
            const token = localStorage.getItem("token");

            const response = await fetch(
                `http://localhost:8080/notes/${id}`,
                {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        Authorization: `Bearer ${token}`
                    }
                }
            );

            const data = await response.json();
            setNote(data);

        } catch (error) {
            console.log(error);
        }
    };

    useEffect(() => {
        getNote();
    }, []);

    if (!note) {
        return <h2>Loading...</h2>;
    }

    return (
        <div style={{ padding: "20px" }}>
            <h1>{note.title}</h1>
            <h3>{note.category}</h3>
            <p>{note.content}</p>
        </div>
    );
}