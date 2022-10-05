import React, { useEffect, useState } from 'react'
import axios from 'axios';
import "../ride.css";
import Table from 'react-bootstrap/esm/Table';
import {ReactSession} from 'react-client-session';

function GetMemberTrainingPlan() {
 
  const user=ReactSession.get("user");
  const [workout,setWorkout]=useState("");
  const [diet, setDiet] = useState("")
  const [add,setAdd]=useState(false)

  console.log(workout);
  console.log(diet);
  useEffect(()=>{

    axios.get("http://localhost:8080/getdietplan/"+user.memid)
      .then((response) => {
        setDiet(response.data);
        setAdd(true)

      })
      .catch((error) => {
        console.log(error);
      })
      axios.get("http://localhost:8080/getWorkoutplan/"+user.memid)
      .then((response) => {
        setWorkout(response.data);
        setAdd(true)

      })
      .catch((error) => {
        console.log(error);
      })

  },[])
  return (
    <div>
   {add && <><Table striped bordered hover className='table-responsive'>
        <thead>
          <tr>
            <th>DAYS</th>
            <th>SUNDAY</th>
            <th>MONDAY</th>
            <th>TUESDAY</th>
            <th>WEDNESDAY</th>
            <th>THURSDAY</th>
            <th>FRIDAY</th>
            <th>SATURDAY</th>
          </tr>
        </thead>
        <tbody>
            <tr>
              <td>WORKOUT</td>
              <td>{workout.sun}</td>
              <td>{workout.mon}</td>
              <td>{workout.tue}</td>
              <td>{workout.wed}</td>
              <td>{workout.thu}</td>
              <td>{workout.fri}</td>
              <td>{workout.sat}</td>
            </tr>
            <tr>
              <td>DIET</td>
              <td>{diet.sun}</td>
              <td>{diet.mon}</td>
              <td>{diet.tue}</td>
              <td>{diet.wed}</td>
              <td>{diet.thu}</td>
              <td>{diet.fri}</td>
              <td>{diet.sat}</td>
            </tr>
        </tbody>
      </Table></>}
    </div>
  )
}
export default GetMemberTrainingPlan;