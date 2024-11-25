import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams, useNavigate} from 'react-router-dom';
import Navbar from '../layout/navbar';

export default function Home() {
    const navigate = useNavigate();
    const [bill, setBill] = useState([])
    const [studentId, setStudentId] = useState("");

    if(!localStorage.getItem("token"))
    {
        window.location.href = "http://localhost:3000/login"
    }

    useEffect(() => {
        loadBills();
    },[]);

    const loadBills = async(studentID)=>{
        const result = await axios.get(`http://localhost:8080/api/bills/read/${studentID}`);
        setBill(result.data);
    }

    const deleteBill = async(studentID, id)=>{
        await axios.delete(`http://localhost:8080/api/bills/delete/${studentID}/${id}`);
        loadBills(studentID);
    }

    const updateBill = (id, description, amount, billDate, deadline, studentId) =>
    {
        navigate("/update", {state : {billId: id, description: description, amount: amount, billDate: billDate, deadline: deadline, studentId: studentId}});
    }

    useEffect(() => {
        const debounceTimeOut = setTimeout(() => {
            if(studentId)
            {
                loadBills(studentId)
            }
        }, 100);

        return () => clearTimeout(debounceTimeOut);
    }, [studentId])

    return (
        <div>
            <Navbar/>
            <h2 className='text-center m-2'>All Bills</h2>
            <div style={{position: "absolute", left: '11px', top: '67px'}}>
                <label style={{marginRight: '10px'}}>Enter Student ID:</label>
                <input
                    type="text"
                    value={studentId}
                    placeholder={"Enter Student ID"}
                    onChange={(e) => setStudentId(e.target.value)}
                />
            </div>
            <table className="table border shadow">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Description</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Bill Date</th>
                    <th scope="col">Deadline</th>
                    <th scope="col">Delete / Update</th>
                </tr>
                </thead>
                <tbody>
                {
                    bill.map((bills, key) => (
                        <tr>
                            <td>{bills.id}</td>
                            <td>{bills.description}</td>
                            <td>{bills.amount}</td>
                            <td>{bills.billDate}</td>
                            <td>{bills.deadline}</td>
                            {/*<td>{bills.studentID}</td>*/}
                            <td>
                                <button className="btn btn-danger mx-2"
                                        onClick={() => deleteBill(studentId, bills.id)}
                                >Delete
                                </button>
                                <button className="btn btn-warning mx-2"
                                        onClick={() => updateBill(bills.id, bills.description, bills.amount, bills.billDate, bills.deadline, studentId)}
                                >Update
                                </button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    )
}
