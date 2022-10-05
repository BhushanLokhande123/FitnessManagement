import { useEffect, useState } from "react";
//import Update from './images/update.webp';
import axios from "axios";
import { ReactSession } from "react-client-session";

function UpdateTrainer() {
  const user = ReactSession.get("user");
  const [fullname, setFullname] = useState(user.fullname);
  const [speciality, setSpeciality] = useState(user.speciality);
  const [email, setEmail] = useState(user.email);
  const [contact, setContact] = useState(user.contactno);
  const [username, setusername] = useState(user.username);
  const [password, setPassword] = useState(user.password);
  const [fees, setFees] = useState(user.fees);
  const [status, setStatus] = useState(user.status);
  const [workexp, setWorkexp] = useState(user.workexp);
  const [messege, setMessege] = useState("");

  function updateData() {
    const updatedUser = {};
    updatedUser.fullname = fullname;
    updatedUser.workexp = workexp;
    updatedUser.speciality = speciality;
    updatedUser.fees = fees;
    updatedUser.email = email;
    updatedUser.contactno = contact;
    updatedUser.username = username;
    updatedUser.password = password;
    updatedUser.tid = user.tid;
    updatedUser.status = status;
    console.log(updatedUser);
    axios
      .post("http://localhost:8080/updatetrainer", updatedUser)
      .then((response) => {
        console.log(response);
        setMessege(response.data);
        alert(" Trainer details updated successfully");
      })
      .catch((error) => {
        console.log(error);
        setMessege(error.data);
      });

    // axios.get("http://localhost:8080/sharesteer/getAllUsers")
    //     .then((response) => {
    //         ReactSession.set("allUser", response.data);
    //     })
    //     .catch((error) => {
    //         console.log(error);
    //     })
  }

  return (
    <section>
      <div className="container py-5 h-100">
        <div className="row d-flex justify-content-center align-items-center h-100">
          <div className="col col-xl-10">
            <div className="card" style={{ borderRadius: " 1rem" }}>
              <div className="row g-0">
                <div className="col-md-6 col-lg-5 d-none d-md-block">
                  <img
                    src={"#"}
                    alt="login form"
                    className="img-fluid"
                    style={{ borderRadius: " 1rem 0 0 1rem" }}
                  />
                  <br />
                  <br />
                  <br />
                </div>
                <div className="col-md-6 col-lg-7 d-flex align-items-center">
                  <div
                    className="card-body p-4 p-lg-5 text-black"
                    style={{ backgroundColor: "rgb(5, 101, 134)" }}
                  >
                    <form action="/home">
                      <div className="d-flex align-items-center mb-3 pb-1">
                        <i
                          className="fas fa-key fa-2x me-3"
                          style={{ color: " #000" }}
                        ></i>
                        <span className="h1 fw-bold mb-0">Update Profile</span>
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">Username</label>
                        <input
                          type="text"
                          placeholder="enter your username"
                          defaultValue={user.username}
                          readOnly
                          className="form-control form-control-lg"
                          required
                          minLength={8}
                          maxLength={16}
                          onBlur={(e) => {
                            setusername(e.target.value);
                          }}
                        />
                      </div>

                      <div className="form-outline mb-4">
                        <label className="form-label">Speciality</label>
                        <input
                          type="text"
                          placeholder="enter your speciality"
                          defaultValue={user.speciality}
                          className="form-control form-control-lg"
                          required
                          minLength={1}
                          maxLength={16}
                          onBlur={(e) => {
                            setSpeciality(e.target.value);
                          }}
                        />
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">Work Experience</label>
                        <input
                          type="number"
                          placeholder="enter your work experience"
                          defaultValue={user.workexp}
                          className="form-control form-control-lg"
                          required
                          minLength={1}
                          maxLength={16}
                          onBlur={(e) => {
                            setWorkexp(e.target.value);
                          }}
                        />
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">Fees</label>
                        <input
                          type="number"
                          placeholder="enter your fees"
                          defaultValue={user.fees}
                          className="form-control form-control-lg"
                          required
                          minLength={1}
                          maxLength={16}
                          onBlur={(e) => {
                            setFees(e.target.value);
                          }}
                        />
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">E-mail</label>
                        <input
                          type="mail"
                          placeholder="enter your email"
                          defaultValue={user.email}
                          className="form-control form-control-lg"
                          required
                          minLength={5}
                          maxLength={70}
                          onBlur={(e) => {
                            setEmail(e.target.value);
                          }}
                        />
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">Contact</label>
                        <input
                          type="number"
                          placeholder="enter your contact no"
                          defaultValue={user.contactno}
                          className="form-control form-control-lg"
                          required
                          minLength={3}
                          maxLength={16}
                          onBlur={(e) => {
                            setContact(e.target.value);
                          }}
                        />
                      </div>

                      <b>{messege}</b>

                      <div className="pt-1 mb-4">
                        <button
                          className="btn btn-dark btn-lg btn-block"
                          type="submit"
                          onClick={updateData}
                        >
                          Update Profile
                        </button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}

export default UpdateTrainer;
