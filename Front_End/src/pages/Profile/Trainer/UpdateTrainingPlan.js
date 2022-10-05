import React, { useEffect, useState } from "react";
import axios from "axios";
import "../ride.css";
import Table from "react-bootstrap/esm/Table";
import { useLocation } from "react-router-dom";
import { ReactSession } from "react-client-session";

function UpdateTrainingPlan() {
  const memid = ReactSession.get("mem");

  const [workout, setWorkout] = useState("");
  const [diet, setDiet] = useState("");
  const [add, setAdd] = useState(false);
  const [check, setCheck] = useState(false);

  const [messege, setMessege] = useState("");
  const [wsun, setWsun] = useState("");
  const [wmon, setWmon] = useState("");
  const [wtue, setWtue] = useState("");
  const [wwed, setWwed] = useState("");
  const [wthu, setWthu] = useState("");
  const [wfri, setWfri] = useState("");
  const [wsat, setWsat] = useState("");
  const [dsun, setDsun] = useState("");
  const [dmon, setDmon] = useState("");
  const [dtue, setDtue] = useState("");
  const [dwed, setDwed] = useState("");
  const [dthu, setDthu] = useState("");
  const [dfri, setDfri] = useState("");
  const [dsat, setDsat] = useState("");

  console.log(workout);
  console.log(diet);
  useEffect(() => {
    console.log(memid);
    axios
      .get("http://localhost:8080/getdietplan/" + memid)
      .then((response) => {
        setDiet(response.data);
        setAdd(true);
      })
      .catch((error) => {
        console.log(error);
      });
    axios
      .get("http://localhost:8080/getWorkoutplan/" + memid)
      .then((response) => {
        setWorkout(response.data);
        setCheck(true);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  function updateDietPlan() {
    const updatedDiet = {};
    updatedDiet.sun = dsun == "" ? diet.sun : dsun;
    updatedDiet.mon = dmon == "" ? diet.mon : dmon;
    updatedDiet.tue = dtue == "" ? diet.tue : dtue;
    updatedDiet.wed = dwed == "" ? diet.wed : dwed;
    updatedDiet.thu = dthu == "" ? diet.thu : dthu;
    updatedDiet.fri = dfri == "" ? diet.fri : dfri;
    updatedDiet.sat = dsat == "" ? diet.sat : dsat;
    updatedDiet.id = memid;
    console.log(updatedDiet);
    axios
      .post("http://localhost:8080/updatedietplan", updatedDiet)
      .then((response) => {
        setMessege(response.data);
        alert(" diet plan successfully updated");
      })
      .catch((error) => {
        console.log(error);
      });
  }

  function updateWorkoutPlan() {
    const updatedWorkout = {};
    updatedWorkout.sun = wsun == "" ? workout.sun : wsun;
    updatedWorkout.mon = wmon == "" ? workout.mon : wmon;
    updatedWorkout.tue = wtue == "" ? workout.tue : wtue;
    updatedWorkout.wed = wwed == "" ? workout.wed : wwed;
    updatedWorkout.thu = wthu == "" ? workout.thu : wthu;
    updatedWorkout.fri = wfri == "" ? workout.fri : wfri;
    updatedWorkout.sat = wsat == "" ? workout.sat : wsat;
    updatedWorkout.id = memid;
    console.log(updatedWorkout);
    axios
      .post("http://localhost:8080/updateworkoutplan", updatedWorkout)
      .then((response) => {
        setMessege(response.data);
        alert(" workout plan successfully updated");
      })
      .catch((error) => {
        console.log(error);
      });
  }
  return (
    <div>
      {add && check && (
        <>
          <Table striped bordered hover className="table-responsive">
            <thead>
              <tr>
                <th>DAYS</th>
                <th>WORKOUT</th>
                <th>DIET</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th>SUNDAY</th>
                <td>
                  <input
                    type="text"
                    defaultValue={workout.sun}
                    onBlur={(e) => {
                      setWsun(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={diet.sun}
                    onBlur={(e) => {
                      setDsun(e.target.value);
                    }}
                  />
                </td>
              </tr>

              <tr>
                <th>MONDAY</th>
                <td>
                  <input
                    type="text"
                    defaultValue={workout.mon}
                    onBlur={(e) => {
                      setWmon(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={diet.mon}
                    onBlur={(e) => {
                      setDmon(e.target.value);
                    }}
                  />
                </td>
              </tr>

              <tr>
                <th>TUESDAY</th>
                <td>
                  <input
                    type="text"
                    defaultValue={workout.tue}
                    onBlur={(e) => {
                      setWtue(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={diet.tue}
                    onBlur={(e) => {
                      setDtue(e.target.value);
                    }}
                  />
                </td>
              </tr>

              <tr>
                <th>WEDNESDAY</th>
                <td>
                  <input
                    type="text"
                    defaultValue={workout.wed}
                    onBlur={(e) => {
                      setWwed(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={diet.wed}
                    onBlur={(e) => {
                      setDwed(e.target.value);
                    }}
                  />
                </td>
              </tr>

              <tr>
                <th>THURSDAY</th>
                <td>
                  <input
                    type="text"
                    defaultValue={workout.thu}
                    onBlur={(e) => {
                      setWthu(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={diet.thu}
                    onBlur={(e) => {
                      setDthu(e.target.value);
                    }}
                  />
                </td>
              </tr>

              <tr>
                <th>FRIDAY</th>
                <td>
                  <input
                    type="text"
                    defaultValue={workout.fri}
                    onBlur={(e) => {
                      setWfri(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={diet.fri}
                    onBlur={(e) => {
                      setDfri(e.target.value);
                    }}
                  />
                </td>
              </tr>

              <tr>
                <th>SATURDAY</th>
                <td>
                  <input
                    type="text"
                    defaultValue={workout.sat}
                    onBlur={(e) => {
                      setWsat(e.target.value);
                    }}
                  />
                </td>
                <td>
                  <input
                    type="text"
                    defaultValue={diet.sat}
                    onBlur={(e) => {
                      setDsat(e.target.value);
                    }}
                  />
                </td>
              </tr>
              <tr>
                <th>Update</th>
                <td>
                  <button
                    className="btn btn-primary"
                    onClick={updateWorkoutPlan}
                    type="button"
                  >
                    Update
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-primary"
                    onClick={updateDietPlan}
                    type="button"
                  >
                    Update
                  </button>
                </td>
              </tr>
            </tbody>
          </Table>
        </>
      )}
      {messege}
    </div>
  );
}
export default UpdateTrainingPlan;
