import axios from 'axios';
import React, {useState} from 'react'
import { Link, useNavigate, useLocation} from 'react-router-dom'
import Navbar from '../layout/navbar';

export default function Update() {

    const navigate = useNavigate();
    const location = useLocation();
    const data = location.state;

    const [bill, setBill] = useState({
        description: data.description,
        amount: data.amount,
        billDate: data.billDate,
        deadline: data.deadline,
        studentID: data.studentId
    });
    const studentID = data.studentId
    const{id, amount, deadline}= bill

    const onInputChange=(e)=>{
        setBill({...bill,[e.target.name]:e.target.value})
    };

    if(!localStorage.getItem("token"))
    {
        window.location.href = "http://localhost:3000/login"
    }
    
    const onSubmit = async (billId)=>{
        await axios.put(`http://localhost:8080/api/bills/update/${studentID}/${billId}`, bill)
        .then(response => response.status)
        .catch(err => console.warn(err))

        navigate("/home")
    };

    return (
        <div>
            <Navbar/>
            <div className='="container'>
                <div className='row d-inline'>
                    <div className='col-md-4 offset-md-4 border rounded p-4 mt-2 shadow'>
                        <h2 className='text-center m-4'>Update Bill</h2>

                        <div className='mb-3'>
                            <label htmlFor="id" className='form-label'>
                                Id
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter Id"
                                name="id"
                                disabled
                                defaultValue={data.billId}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor="description" className='form-label'>
                                Description
                            </label>
                            <input type={"text"}
                                   className="form-control"
                                   placeholder="Enter description"
                                   name="description"
                                   defaultValue={data.description}
                                   onChange={(e) => onInputChange(e)}/>
                            <br/>
                        </div>
                            <div className='mb-3'>
                                <label htmlFor="amount" className='form-label'>
                                    Amount
                                </label>
                                <input type={"number"}
                                       className="form-control"
                                       placeholder="Enter amount"
                                       name="amount"
                                       defaultValue={data.amount}
                                       onChange={(e) => onInputChange(e)}/>
                                <br/>
                            </div>
                            <div className='mb-3'>
                                <label htmlFor="deadline" className='form-label'>
                                    Deadline
                                </label>
                                <input type={"text"}
                                       className="form-control"
                                       placeholder="Enter deadline"
                                       name="deadline"
                                       defaultValue={data.deadline}
                                       onChange={(e) => onInputChange(e)}/>
                                <br/>
                            </div>
                            <button type="submit" className='btn btn-outline-primary'
                                    onClick={() => onSubmit(data.billId)}
                            >
                                Update
                            </button>
                            <Link className='btn btn-outline-primary mx-2' to="/home">
                                Back
                            </Link>

                        </div>
                    </div>
                </div>
            </div>
            )
            }