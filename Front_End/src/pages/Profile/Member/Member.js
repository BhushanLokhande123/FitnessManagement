import React, { useEffect, useState } from 'react'
import axios from 'axios';
//import User from './images/user.jpg'
import { ReactSession } from 'react-client-session';
import { NavDropdown } from 'react-bootstrap';
function Member() {
  const [member, setMember] = useState("");
ThirdPage();
function ThirdPage() {
 
  const id = ReactSession.get("userId");
 useEffect(() => {
     axios.get("http://localhost:8080/getmember/" +id)
     .then((response) => { 
      setMember(response.data)  
       ReactSession.set("user", response.data);
     }).catch((error) => { console.log(error); })
 },[])
}
  return (
    <center>
    <div id='ride'>
      <div className="card">
        <div className="card-body">
        {/* <img src={'#'} style={{'borderRadius':'50%','height':'400px','width':'350px'}} /> */}
        <h1 className="card-title">{member.fullname}</h1>
                <NavDropdown title="Select" id="basic-nav-dropdown" className="btn btn-dark" alignRight>
                    <NavDropdown.Item href="/updatemember">Update Profile</NavDropdown.Item>
                    <NavDropdown.Item href="/getmembertrainingplan">Get Training Plan</NavDropdown.Item>
                    <NavDropdown.Item href="/gettrainerinfo">Get Trainer Info</NavDropdown.Item>
                </NavDropdown>
        </div>
        <ul className="list-group list-group-flush">
        <li className="list-group-item"><b>Login_id </b>:{member.loginid}</li>
        <li className="list-group-item"><b>Username </b>:{member.username}</li>
        <li className="list-group-item"><b>Role </b>:{member.role}</li>
          <li className="list-group-item"><b>Gender </b>:{member.gender}</li>
          <li className="list-group-item"><b>Height </b>:{member.height}</li>
          <li className="list-group-item"><b>Chest_Size </b>:{member.chest}</li>
          <li className="list-group-item"><b>Weight </b>:{member.weight}</li>
          <li className="list-group-item"><b>Waist_size </b>:{member.waist}</li>
          <li className="list-group-item"><b>Status </b>:{member.status}</li>
          <li className="list-group-item"><b>Email </b>: {member.email}</li>
          <li className="list-group-item"><b>Contact No </b>: {member.contactno}</li>
        </ul>
      </div>

    </div>
    </center>
  )
}

export default Member