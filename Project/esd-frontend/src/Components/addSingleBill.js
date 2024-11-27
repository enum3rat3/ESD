import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Navbar from '../layout/navbar';

export default function AddSingleBill() {

    const navigate = useNavigate();
    let currDate = new Date();
    currDate = currDate.getFullYear() + "-" + parseInt(currDate.getMonth()+1) + "-" + currDate.getDate();


    const [bill, setBill] = useState({
            description:"",
            amount:"",
            billDate:currDate,
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
        try{
            const response = await axios.post('http://localhost:8080/api/bills/create', bill);
            // navigate("/home");
            toast.success("Billed for student id: " + bill.studentID);
        }
        catch (error) {
            toast.error(error.response.data.message);
        }
    };


    return (
        <div>
            <ToastContainer />
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
                                <label htmlFor="description" className='form-label'>
                                    Deadline
                                </label>
                                <input type={"date"}
                                       className="form-control"
                                       placeholder="Enter deadline"
                                       name="deadline"
                                       value={deadline}
                                       min={currDate}
                                       onChange={(e) => onInputChange(e)} />
                            </div>

                            <div className='mb-3'>
                                <label htmlFor="name" className='form-label'>
                                    Student ID
                                </label>
                                <input type={"text"}
                                       className="form-control"
                                       placeholder="Enter student ID"
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
