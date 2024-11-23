import axios from 'axios';
import React, {useState} from 'react'
import { Link, useNavigate} from 'react-router-dom'
import Navbar from '../layout/navbar';

export default function Update() {

    let navigate = useNavigate;

    const [bill, setBill] = useState("");

    const{id, amount, deadline}= bill

    const onInputChange=(e)=>{
        setBill({...bill,[e.target.name]:e.target.value})
    };

    const onSubmitAmount = async (bill_id, amount)=>{
        await axios.post(`http://localhost:8080/MiniProjectERP-1.0-SNAPSHOT/api/bills/updateamt/${bill_id}/${amount}`)
            .then(response => response.status)
            .catch(err => console.warn(err))

        navigate("/home")
    };

    const onSubmitDead = async (b_id, deadline)=>{
        await axios.post(`http://localhost:8080/MiniProjectERP-1.0-SNAPSHOT/api/bills/updatedeadline/${b_id}/${deadline}`)
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
                            <label htmlFor= "id" className='form-label'>
                                Id
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter Id"
                                name="id"
                                value={id}
                                onChange={(e)=>onInputChange(e)}/>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor= "amount" className='form-label'>
                                Amount
                            </label>
                            <input type={"number"}
                                   className="form-control"
                                   placeholder="Enter amount"
                                   name="amount"
                                   value={amount}
                                   onChange={(e)=>onInputChange(e)}/>
                            <br/>
                            <button type="submit" className='btn btn-outline-primary'
                                    onClick={()=>onSubmitAmount(id, amount)}
                            >
                                Update
                            </button>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor= "deadline" className='form-label'>
                                Deadline
                            </label>
                            <input type={"text"}
                                   className="form-control"
                                   placeholder="Enter deadline"
                                   name="deadline"
                                   value={deadline}
                                   onChange={(e)=>onInputChange(e)}/>
                            <br/>
                            <button type="submit" className='btn btn-outline-primary'
                                    onClick={()=>onSubmitDead(id, deadline)}
                            >
                                Update
                            </button>
                        </div>
                        <Link className='btn btn-outline-danger mx-2' to="/home" >
                            Back
                        </Link>

                    </div>
                </div>
            </div>
        </div>
    )
}