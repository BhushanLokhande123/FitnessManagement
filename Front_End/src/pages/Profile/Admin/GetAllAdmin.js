import React, { useEffect, useState } from 'react'
import axios from 'axios';
import "../ride.css";

function GetAllAdmin() {
  
  
  const [admin,setAdmin]=useState([])
  const [add,setAdd]=useState(false)
console.log(admin);

  useEffect(()=>{

    axios.get("http://localhost:8080/getalladmin")
      .then((response) => {
        setAdmin(response.data);
        setAdd(true)

      })
      .catch((error) => {
        console.log(error);
      })

  },[])

  
  return (
    <div>
    {add && admin.map((info,index)=>(<div id='ride' key={index} style={{'textAlign':'center'}}>
      <div className="card">
        <div className="card-body">
          <h5 className='btn btn-dark btn-lg btn-block'><b>Admin Details</b></h5>
        </div>
        <ul className="list-group list-group-flush">
          <li className="list-group-item"><b>Admin Id</b>:{info.aid}</li>
          <li className="list-group-item"><b>Full Name</b>:{info.fullname}</li>
          <li className="list-group-item"><b>Email</b> :{info.email}</li>
          <li className="list-group-item"><b>Contact No</b> : {info.contactno}</li>
          <li className="list-group-item"><b>Status</b> : {info.status}</li>
        </ul>
        
      </div>
    </div>))}
    </div>
  )
}
export default GetAllAdmin;