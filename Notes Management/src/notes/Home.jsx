import { useEffect, useState } from "react";
import "./Home.css";

export default function Home() {
    const [notes, setNotes] = useState([]);
    const [page, setPage] = useState(0);
    const [search, setSearch] = useState("");
    const getNotes = async (currentPage = 0) => {
        try {
            const token = localStorage.getItem("token");

            const response = await fetch(
                `http://localhost:8080/notes?page=${currentPage}&size=10`,
                {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                        Authorization: `Bearer ${token}`
                    }
                }
            );
            if (response.ok) {
                const data = await response.json();

                setNotes((prev) => {
                    const allNotes = [...prev, ...data];
                    const uniqueNotes = allNotes.filter((note, index, self) => index === self.findIndex((n) => n.id === note.id));
                    return uniqueNotes;
                });
            } else {
                console.log("Failed to fetch notes");
            }
        } catch (error) {
            console.log("Error fetching notes:", error);
        }
    };
    useEffect(() => { getNotes(0); }, []);

    const loadMore = () => { const nextPage = page + 1; setPage(nextPage); getNotes(nextPage); };

    const logout = () => {
        localStorage.removeItem("token");
        window.location.href = "/login";
    };

    return (
        <>
            <header>
                <nav className="nav">
                    <h1>📝 Notes App</h1>

                    {/* Search Input */}
                    <input type="text" placeholder="Search notes..." value={search} onChange={(e) => setSearch(e.target.value)} />
                    <button onClick={logout}> Logout </button>
                </nav>
            </header>
            <main>
                <div className="notes">
                    {notes.length > 0 ? (
                        notes
                            .filter((note) =>
                                note.title
                                    .toLowerCase()
                                    .includes(search.toLowerCase())
                            )
                            .map((note) => (
                                <div
                                    key={note.id}
                                    className="note"
                                    onClick={() =>
                                        (window.location.href = `/note/${note.id}`)
                                    }
                                >
                                    <h2>{note.title}</h2>

                                    <p>
                                        {note.content
                                            ? note.content.substring(0, 30)
                                            : "No content"}
                                        ...
                                    </p>
                                </div>
                            ))
                    ) : (
                        <h2>No Notes Found</h2>
                    )}
                </div>
            </main>

            <footer>
                <button onClick={loadMore}>
                    Load More
                </button>
            </footer>
        </>
    );
}