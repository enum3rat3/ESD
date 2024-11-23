import React from 'react'
import { Link } from 'react-router-dom'
export default function Navbar2() {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-dark" style={{backgroundColor: '#ff6600'}}>
                <div className="container-fluid">
                    <a className="navbar-brand" href="/home">Fee Details CRUD</a>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent"></div>
                </div>
            </nav>
        </div>
    )
}
