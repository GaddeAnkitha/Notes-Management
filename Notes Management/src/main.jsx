import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";

import Register from "./notes/Register.jsx";
import Login from "./notes/Login.jsx";
import Home from "./notes/Home.jsx";
import ViewNote from "./notes/ViewNote.jsx";

import { BrowserRouter, Routes, Route } from "react-router-dom";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/notes" element={<Home />} />   {/* Add this */}
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/note/:id" element={<ViewNote />} />
      </Routes>
    </BrowserRouter>
  </StrictMode>
);