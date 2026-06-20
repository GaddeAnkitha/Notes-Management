import { useState } from "react";
import "./Register.css";
import { Link, useNavigate } from "react-router-dom";

export default function Register() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const handleRegister = async () => {
    try {
      const response = await fetch(
        "http://localhost:8080/users/register",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({
            name: name,
            email: email,
            password: password
          })
        }
      );

      const data = await response.json();
      console.log(data);

      if (response.ok) {
        alert("User Registered Successfully");
        navigate("/login");
      } else {
        alert(data.message || "Registration Failed");
      }
    } catch (error) {
      console.log(error);
      alert("Server Error");
    }
  };

  return (
    <div className="box">
      <h1>Register</h1>

      <input type="text" placeholder="Enter Name" value={name} onChange={(e) => setName(e.target.value)} />
      <input type="email" placeholder="Enter Email" value={email} onChange={(e) => setEmail(e.target.value)} />
      <input type="password" placeholder="Enter Password" value={password} onChange={(e) => setPassword(e.target.value)} />
      <button onClick={handleRegister}> Register</button>
      <p> Already have an account?{" "}  <Link to="/login">Login</Link> </p>
    </div>
  );
}