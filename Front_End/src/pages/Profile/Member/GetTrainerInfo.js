import React, { useEffect, useState } from 'react'
import axios from 'axios';
import "../ride.css";

function GetTrainerInfo() {
 
  const [trainer,setTrainer]=useState([])
  const [add,setAdd]=useState(false)

  useEffect(()=>{

    axios.get("http://localhost:8080/getalltrainer")
      .then((response) => {
        setTrainer(response.data);
        setAdd(true)

      })
      .catch((error) => {
        console.log(error);
      })

  },[])
  return (
    <div>
    {add && trainer.map((info,index)=>(<div id='ride' key={index} style={{'textAlign':'center'}}>
      <div className="card">
        <div className="card-body">
          <h5 className='btn btn-dark btn-lg btn-block'><b>Trainer Info</b></h5>
        </div>
        <ul className="list-group list-group-flush">
          <li className="list-group-item"><b>Fullname</b> :{info.fullname}</li>
          <li className="list-group-item"><b>Trainer Id</b>:{info.tid}</li>
          <li className="list-group-item"><b>Contact No</b>:{info.contactno}</li>
          <li className="list-group-item"><b>E-Mail</b>:{info.email}</li>
          <li className="list-group-item"><b>Speciality</b> :{info.speciality}</li>
          <li className="list-group-item"><b>Status</b> : {info.status}</li>
        </ul>
      </div>
    </div>))}
    </div>
  )
}
export default GetTrainerInfo;