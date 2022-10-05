import React, { useEffect, useState } from "react";
import Table from "react-bootstrap/Table";
import axios from "axios";
export default function AllUser() {
  const [users, setUsers] = useState([]);
  const [user, setUser] = useState("");
  const [fullname, setFullname] = useState(user.fullname);
  const [email, setEmail] = useState(user.email);
  const [contactno, setContactno] = useState(user.email);
  const [speciality, setSpeciality] = useState(user.speciality);
  const [status, setStatus] = useState(user.status);
  const [workexp, setWorkexp] = useState(user.workexp);
  const [fees, setFees] = useState(user.fees);

  const [check, setCheck] = useState(false);

  useEffect(() => {
    axios
      .get("http://localhost:8080/getalltrainer")
      .then((response) => {
        setUsers(response.data);
        setCheck(true);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  function updateData(user) {
    console.log(user);
    const updatedUser = {};
    updatedUser.tid = user.tid;
    updatedUser.contactno = contactno == undefined ? user.contactno : contactno;
    updatedUser.email = email == undefined ? user.email : email;
    updatedUser.fees = fees == undefined ? user.fees : fees;
    updatedUser.fullname = fullname == undefined ? user.fullname : fullname;
    updatedUser.speciality =
      speciality == undefined ? user.speciality : speciality;
    updatedUser.status = status == undefined ? user.status : status;
    updatedUser.workexp = workexp == undefined ? user.workexp : workexp;
    updatedUser.loginid = user.loginid;

    console.log(updatedUser);
    axios
      .post("http://localhost:8080/adminupdatetrainer", updatedUser)
      .then((response) => {
        console.log(response);
        alert(" trainer details updated successfully");
      })

      .catch((error) => {
        console.log(error);
      });
  }
  return (
    <div style={{ textAlign: "center" }}>
      <br />
      <br />

      <h1>
        <b>TRAINER-INFORMATION</b>
      </h1>
      <br />

      <Table striped bordered hover className="table-responsive">
        <thead>
          <tr>
            <th>Trainer ID</th>
            <th>Full Name</th>
            <th>Speciality</th>
            <th>WorkExp</th>
            <th>Fees</th>
            <th>Email</th>
            <th>ContactNo</th>
            <th>Status</th>
            <th>Login Id(unique entity)</th>
          </tr>
        </thead>
        <tbody>
          {check &&
            users.map((user, index) => (
              <tr key={index}>
                <td>{user.tid}</td>

                <td>
                  <input
                    type="text"
                    defaultValue={user.fullname}
                    required
                    onBlur={(e) => {
                      setFullname(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.speciality}
                    required
                    onBlur={(e) => {
                      setSpeciality(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.workexp}
                    required
                    onBlur={(e) => {
                      setWorkexp(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.fees}
                    onBlur={(e) => {
                      setFees(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.email}
                    onBlur={(e) => {
                      setEmail(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="email"
                    defaultValue={user.contactno}
                    onBlur={(e) => {
                      setContactno(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.status}
                    required
                    onBlur={(e) => {
                      setStatus(e.target.value);
                      setUser(user);
                    }}
                  />
                </td>
                <td>{user.loginid}</td>
                <td>
                  <button
                    className="btn btn-dark"
                    onClick={() => {
                      updateData(user);
                    }}
                  >
                    Update
                  </button>
                </td>
              </tr>
            ))}
        </tbody>
      </Table>
    </div>
  );
}
