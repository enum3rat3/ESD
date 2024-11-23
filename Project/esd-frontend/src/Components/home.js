import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom';
import Navbar from '../layout/navbar';

export default function Home() {
    const [bill, setBill] = useState([])
    const [studentId, setStudentId] = useState("");

    useEffect(() => {
        loadBills();
    },[]);

    const loadBills = async(studentID)=>{
        const result = await axios.get(`http://localhost:8080/api/bills/read/${studentID}`,
            {
                headers: {"Authorization": `Bearer ${localStorage.getItem("token")}`}
            });
        setBill(result.data);
    }

    const deleteBill = async(studentID, id)=>{
        await axios.delete(`http://localhost:8080/api/bills/delete/${studentID}/${id}`);
        loadBills();
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
                    <th scope="col">Student ID</th>
                </tr>
                </thead>
                <tbody>
                {
                    bill.map((bills, index) => (
                        <tr>
                            <td>{bills.id}</td>
                            <td>{bills.description}</td>
                            <td>{bills.amount}</td>
                            <td>{bills.billDate}</td>
                            <td>{bills.deadline}</td>
                            {/*<td>{bills.studentID}</td>*/}
                            <td>
                                <button className="btn btn-danger mx-2"
                                        onClick={() => deleteBill(101, bills.id)}
                                >Delete
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
