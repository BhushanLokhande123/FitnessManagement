import React, { useEffect, useState } from "react";
import Table from "react-bootstrap/Table";
import axios from "axios";
import { ReactSession } from "react-client-session";
import { useHistory } from "react-router-dom";
export default function AllUser() {
  const [users, setUsers] = useState([]);
  const [user, setUser] = useState("");
  const [fullname, setFullname] = useState(user.fullname);
  const [email, setEmail] = useState(user.email);
  const [contactno, setContactno] = useState(user.email);
  const [tid, setTid] = useState(user.tid);
  const [height, setHeight] = useState(user.height);
  const [weight, setWeight] = useState(user.weight);
  const [chest, setChest] = useState(user.chest);
  const [injury, setInjury] = useState(user.injury);
  const [gender, setGender] = useState(user.gender);
  const [waist, setWaist] = useState(user.waist);
  const [status, setStatus] = useState(user.status);
  const [check, setCheck] = useState(false);
  const history = useHistory();

  function update(id) {
    ReactSession.set("mem", id);
    history.push({
      pathname: "/updatetrainingplan",
      state: id,
    });
  }
  useEffect(() => {
    axios
      .get("http://localhost:8080/getallmember")
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
    updatedUser.memid = user.memid;
    updatedUser.contactno = contactno == undefined ? user.contactno : contactno;
    updatedUser.email = email == undefined ? user.email : email;
    updatedUser.height = height == undefined ? user.height : height;
    updatedUser.fullname = fullname == undefined ? user.fullname : fullname;
    updatedUser.weight = weight == undefined ? user.weight : weight;
    updatedUser.status = status == undefined ? user.status : status;
    updatedUser.chest = chest == undefined ? user.chest : chest;
    updatedUser.waist = waist == undefined ? user.waist : waist;
    updatedUser.injury = injury == undefined ? user.injury : injury;
    updatedUser.tid = tid == undefined ? user.tid : tid;
    updatedUser.gender = gender == undefined ? user.gender : gender;
    updatedUser.loginid = user.loginid;

    console.log(updatedUser);
    axios
      .post("http://localhost:8080/adminupdatemember", updatedUser)
      .then((response) => {
        console.log(response);
        alert(" member details updated successfully");
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
        <b>MEMBER-INFORMATION</b>
      </h1>
      <br />

      <Table striped bordered hover className="table-responsive">
        <thead>
          <tr>
            <th>Member ID</th>
            <th>Full Name</th>
            <th>Gender</th>
            <th>Height</th>
            <th>Weight</th>
            <th>Chest</th>
            <th>Waist</th>
            <th>Injury</th>
            <th>Trainer Id</th>
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
                <td>{user.memid}</td>

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
                    defaultValue={user.gender}
                    required
                    onBlur={(e) => {
                      setGender(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.height}
                    required
                    onBlur={(e) => {
                      setHeight(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.weight}
                    onBlur={(e) => {
                      setWeight(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.chest}
                    onBlur={(e) => {
                      setChest(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.waist}
                    onBlur={(e) => {
                      setWaist(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.injury}
                    onBlur={(e) => {
                      setInjury(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={user.tid}
                    onBlur={(e) => {
                      setTid(e.target.value);
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
                {/* <td>
                  <button
                    className="btn btn-primary"
                    onClick={() => {
                      update(user.memid);
                    }}
                    type="button"
                  >
                    Training Plan
                  </button>
                </td> */}
              </tr>
            ))}
        </tbody>
      </Table>
    </div>
  );
}
