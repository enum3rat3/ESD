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
                            <li className="nav-item dropdown">
                                <Link className="nav-link dropdown-toggle" to="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Add Bill
                                </Link>
                                <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <Link className="dropdown-item" to="/addSingleBill">Add Single Bill</Link>
                                    <Link className="dropdown-item" to="/addBills">Add Bill to Domain</Link>
                                </div>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/update">Update</Link>
                            </li>
                        </ul>
                    </div>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <Link className='btn btn-outline-light mx-2' to="/login">
                        Logout
                    </Link>
                </div>
            </nav>
        </div>
    )
}
