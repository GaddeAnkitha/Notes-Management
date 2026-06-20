import { useState } from "react";
import "./Register.css";
import { Link, useNavigate } from "react-router-dom";

export default function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    const handleLogin = async () => {
        try {
            const response = await fetch(
                "http://localhost:8080/users/login",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        email: email,
                        password: password
                    })
                }
            );

            if (response.ok) {
                const token = await response.text();
                console.log(token);
                localStorage.setItem("token", token);
                alert("Login Successful");
                navigate("/notes");
            } else {
                const error = await response.json();
                alert(error.message);
            }
        } catch (error) {
            console.log(error);
            alert("Server Error");
        }
    };
    return (
        <div className="box">
            <h1>Login</h1>

            <input type="email" placeholder="Enter Email" value={email} onChange={(e) => setEmail(e.target.value)} />
            <input type="password" placeholder="Enter Password" value={password} onChange={(e) => setPassword(e.target.value)} />
            <button onClick={handleLogin}> Login </button>
            <p> Don't have an account?{" "}  <Link to="/register">Register</Link> </p>
        </div>
    );
}