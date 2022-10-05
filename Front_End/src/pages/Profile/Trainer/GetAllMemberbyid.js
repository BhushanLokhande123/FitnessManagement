import React, { useEffect, useState } from 'react'
import { ReactSession } from 'react-client-session';

import axios from 'axios';
import "../ride.css";
import Table from 'react-bootstrap/esm/Table';
import { useHistory } from 'react-router-dom';

function GetAllMemberbyid() {
  const user = ReactSession.get("user");
  const id = user.tid
  const [member,setMember]=useState([])
  const [add,setAdd]=useState(false)
  const history=useHistory();

  useEffect(()=>{

    axios.get("http://localhost:8080/getallmemberbytrainerid/"+id)
      .then((response) => {
        setMember(response.data);
        setAdd(true)

      })
      .catch((error) => {
        console.log(error);
      })

  },[])

  function update(id)
  {
    ReactSession.set("mem",id);
    history.push({
      pathname:'/updatetrainingplan',
      state:id
    })

  }
  return (
    <div>
<div style={{'textAlign':'center'}}>
      <br/>
      <br/>
      <h1><b>MEMBER-INFORMATION</b></h1>
      <br/>
      <Table  striped bordered hover variant="dark" style={{ 'textAlign': 'center'}}>
        <thead>
          <tr>
            <th>Member ID</th>
            <th>Full Name</th>
            <th>Trainer Id</th>
            <th>Height</th>
            <th>Weight</th>
            <th>Chest</th>
            <th>Waist</th>
            <th>Injury</th>
            <th>Email</th>
            <th>ContactNo</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {add && member.map((info, index) => (
            <tr key={index}>
              <td>{info.memid}</td>
              <td>{info.fullname}</td>
              <td>{info.tid}</td>
              <td>{info.height}</td>
              <td>{info.weight}</td>
              <td>{info.chest}</td>
              <td>{info.waist}</td>
              <td>{info.injury}</td>
              <td>{info.email}</td>
              <td>{info.contactno}</td>
              <td>{info.status}</td>
              <td><button className="btn btn-primary" onClick={()=>{update(info.memid)}} type="button">Training Plan</button></td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
    </div>
  )
}
export default GetAllMemberbyid;