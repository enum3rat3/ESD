import React from 'react'
import { Link } from 'react-router-dom'
export default function Navbar() {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-dark" style={{backgroundColor: '#ff6600'}}>
                <div className="container-fluid">
                    <Link className="navbar-brand" to="/home">Fee Details CRUD</Link>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item active">
                                <Link className="nav-link" to="/home">Home <span className="sr-only">(current)</span></Link>
                            </li>
                            <li className="nav-item active">
                                <Link className="nav-link" to="/addSingleBill">Add Single Bill</Link>
                            </li>
                            <li className="nav-item active">
                                <Link className="nav-link" to="/addBills">Add Bill to Domain</Link>
                            </li>
                        </ul>
                    </div>


                    <Link className='btn btn-outline-light mx-2' to="/login">
                        Logout
                    </Link>
                </div>
            </nav>
        </div>
    )
}
