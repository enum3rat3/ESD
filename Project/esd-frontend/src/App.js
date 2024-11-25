import './App.css';

import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Login from './Components/login';
import Home from './Components/home';
import AddSingleBill from './Components/addSingleBill';
import AddBillToDomain from './Components/addBillToDomain';
import Update from './Components/update';
import {history} from "./helpers/history";
import {setAuthToken} from "./helpers/setAuthToken";


function App() {
    const token = localStorage.getItem("token");
    if (token) {
        setAuthToken(token);
    }
    return (
      <div className="App">
        <Router history={history}>
            <Routes>
            <Route exact path="/" element={<Login />} />
            <Route exact path="/home" element={<Home />} />
            <Route exact path="/addSingleBill" element={<AddSingleBill />} />
            <Route exact path="/addBills" element={<AddBillToDomain />} />
            <Route exact path="/update" element={<Update />} />
            <Route exact path="/login" element={<Login />} />
            </Routes>
        </Router>
      </div>
  );
}

export default App;