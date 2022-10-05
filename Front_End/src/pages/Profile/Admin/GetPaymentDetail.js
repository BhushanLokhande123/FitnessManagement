import React, { useEffect, useState } from 'react'
import axios from 'axios';
import "../ride.css";
import Table from 'react-bootstrap/esm/Table';

function AllRides() {


  const [payment, setPayment] = useState([])
  const [add, setAdd] = useState(false)
  console.log(payment);

  useEffect(() => {

    axios.get("http://localhost:8080/getpaymentdetails")
      .then((response) => {
        setPayment(response.data);
        setAdd(true)

      })
      .catch((error) => {
        console.log(error);
      })

  }, [])


  return (
    <div style={{ 'textAlign': 'center' }}>
      <br />
      <br />
      <center>
        <h2><b>PAYMENT-DETAILS</b></h2>
        <br />
        <br />
        <Table striped bordered hover variant="dark" style={{ 'textAlign': 'center'}}>
          <thead>
            <tr>
              <th>Transaction ID</th>
              <th>Amount</th>
              <th>Name</th>
              <th>Login ID</th>
            </tr>
          </thead>
          <tbody>
            {add && payment.map((trans, index) => (
              <tr key={index}>
                <td>{trans.pid}</td>
                <td>₹.{trans.fees}</td>
                <td>{trans.name}</td>
                <td>{trans.loginid}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </center>
    </div>
  )
}
export default AllRides;