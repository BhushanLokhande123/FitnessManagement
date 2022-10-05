import React, { useState } from 'react'
import axios from 'axios';
import { ReactSession } from 'react-client-session';
import { useEffect } from 'react';
import { NavDropdown } from 'react-bootstrap';

function Admin() {
 // const [userId, setUserId] = useState("");
  const [admin, setAdmin] = useState("");
  
  const id=ReactSession.get("userId");
//  const user= ReactSession.get("user");
  

  ThirdPage();
   function ThirdPage() {
    useEffect(() => {
        axios.get("http://localhost:8080/getadmin/" +id)
        .then((response) => { 
          setAdmin(response.data)  
          ReactSession.set("user", response.data);
        }).catch((error) => { console.log(error); })
    },[])
  }



  return (
    <center>
      <div >
    
        <div className="card">
          <div className="card-body">
            <h1 className="card-title">{admin.fullname}</h1>
                 <NavDropdown title="Select" id="basic-nav-dropdown" className="btn btn-dark" alignRight>
                    <NavDropdown.Item href="/updateadmin">Update Profile</NavDropdown.Item>
                    <NavDropdown.Item href="/getalltrainer">Get All Trainer</NavDropdown.Item>
                    <NavDropdown.Item href="/getallmember">Get All Member</NavDropdown.Item>
                    <NavDropdown.Item href="/getalladmin">Get All Admin</NavDropdown.Item>
                    <NavDropdown.Item href="/getallpaymentdetail">Get All Payment</NavDropdown.Item>
                </NavDropdown>
          </div>
          <ul className="list-group list-group-flush">
            <li className="list-group-item"><b>role </b>:{admin.role}</li>
            <li className="list-group-item"><b>username </b>:{admin.username}</li>
            <li className="list-group-item"><b>status </b>:{admin.status}</li>
            <li className="list-group-item"><b>Email </b>: {admin.email}</li>
            <li className="list-group-item"><b>Contact No </b>: {admin.contactno}</li>
          </ul>
        
        </div>
      
      </div>
    </center>
  )
}

export default Admin