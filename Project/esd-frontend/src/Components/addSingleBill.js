import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import Navbar from '../layout/navbar';

export default function AddSingleBill() {

    const navigate = useNavigate();

    const [bill, setBill] = useState({
            description:"",
            amount:"",
            billDate:"",
            deadline:"",
            studentID:""
        }
    );

    if(!localStorage.getItem("token"))
    {
        window.location.href = "http://localhost:3000/login"
    }
    const { description, amount, billDate, deadline, studentID } = bill

    const onInputChange = (e) => {
        setBill({ ...bill, [e.target.name]: e.target.value })
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post('http://localhost:8080/api/bills/create', bill)
        navigate("/home")
    };


    return (
        <div>
            <Navbar/>
            <div className="container">
                <div className='row d-inline'>
                    <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                        <h2 className='text-center m-4'>Add new Bill</h2>
                        <form onSubmit={(e) => onSubmit(e)}>
                            <div className='mb-3'>
                                <label htmlFor="description" className='form-label'>
                                    Description
                                </label>
                                <input
                                    type={"text"}
                                    className="form-control"
                                    placeholder="Enter description"
                                    name="description"
                                    value={description}
                                    onChange={(e) => onInputChange(e)} />
                            </div>

                            <div className='mb-3'>
                                <label htmlFor="amount" className='form-label'>
                                    Amount
                                </label>
                                <input
                                    type={"number"}
                                    className="form-control"
                                    placeholder="Enter amount"
                                    name="amount"
                                    value={amount}
                                    onChange={(e) => onInputChange(e)} />
                            </div>

                            <div className='mb-3'>
                                <label htmlFor="credits_required" className='form-label'>
                                    Date
                                </label>
                                <input type={"text"}
                                       className="form-control"
                                       placeholder="Enter bill date"
                                       name="billDate"
                                       value={billDate}
                                       onChange={(e) => onInputChange(e)} />
                            </div>

                            <div className='mb-3'>
                                <label htmlFor="description" className='form-label'>
                                    Deadline
                                </label>
                                <input type={"text"}
                                       className="form-control"
                                       placeholder="Enter deadline"
                                       name="deadline"
                                       value={deadline}
                                       onChange={(e) => onInputChange(e)} />
                            </div>

                            <div className='mb-3'>
                                <label htmlFor="name" className='form-label'>
                                    Student_id
                                </label>
                                <input type={"text"}
                                       className="form-control"
                                       placeholder="Enter student_id"
                                       name="studentID"
                                       value={studentID}
                                       onChange={(e) => onInputChange(e)} />
                            </div>

                            <button type="submit" className='btn btn-outline-primary'>
                                Add
                            </button>

                            <Link className='btn btn-outline-danger mx-2' to="/home" >
                                Cancel
                            </Link>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}
