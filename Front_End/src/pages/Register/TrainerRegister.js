import { useEffect, useState } from "react";
import i1 from "./11.jpg";
import i2 from "./12.webp";
import i3 from "./16.jpg";
import i4 from "./14.webp";
import i5 from "./15.jpg";
import i6 from "./13.jpg";
import axios from "axios";

function TrainerRegister() {
  const [fullname, setFullname] = useState("");
  const [speciality, setSpeciality] = useState("");
  const [email, setEmail] = useState("");
  const [contact, setContact] = useState("");
  const [username, setusername] = useState("");
  const [password, setPassword] = useState("");
  const [fees, setFees] = useState("");
  const [status, setStatus] = useState("");
  const [workexp, setWorkexp] = useState("");
  const [messege, setMessege] = useState("");

  function addData() {
    const user = {};
    user.fullname = fullname;
    user.workexp = workexp;
    user.speciality = speciality;
    user.fees = fees;
    user.email = email;
    user.contactno = contact;
    user.username = username;
    user.password = password;
    user.status = status;

    console.log(user);

    if (
      fullname == "" ||
      username == "" ||
      password == "" ||
      status == "" ||
      email == "" ||
      contact == "" ||
      workexp == "" ||
      speciality == "" ||
      fees == ""
    ) {
      setMessege("Fill Necessary Details");
      return;
    }

    axios
      .post("http://localhost:8080/registertrainer", user)
      .then((response) => {
        setMessege(response.data);
      })
      .catch((error) => {
        setMessege(error.data);
      });
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
                    src={i1}
                    alt="login form"
                    className="img-fluid"
                    style={{ borderRadius: " 1rem 0 0 1rem" }}
                  />
                  <br />
                  <br />
                  <br />
                  <img
                    src={i2}
                    alt="login form"
                    className="img-fluid"
                    style={{ borderRadius: " 1rem 0 0 1rem" }}
                  />
                  <br />
                  <br />
                  <br />
                  <img
                    src={i3}
                    alt="login form"
                    className="img-fluid"
                    style={{ borderRadius: " 1rem 0 0 1rem" }}
                  />
                  <br />
                  <br />
                  <br />
                  <img
                    src={i4}
                    alt="login form"
                    className="img-fluid"
                    style={{ borderRadius: " 1rem 0 0 1rem" }}
                  />
                  <br />
                  <br />
                  <br />
                  <img
                    src={i6}
                    alt="login form"
                    className="img-fluid"
                    style={{ borderRadius: " 1rem 0 0 1rem" }}
                  />
                  <br />
                  <br />
                  <br />
                  <img
                    src={i5}
                    alt="login form"
                    className="img-fluid"
                    style={{ borderRadius: " 1rem 0 0 1rem" }}
                  />
                </div>
                <div className="col-md-6 col-lg-7 d-flex align-items-center">
                  <div
                    className="card-body p-4 p-lg-5 text-black"
                    style={{ backgroundColor: "rgb(5, 101, 134)" }}
                  >
                    <form>
                      <a
                        className="form-select btn btn-dark btn-lg btn-block"
                        href="/memberregistration"
                      >
                        Member Registration
                      </a>
                      {/* <a className="form-select btn btn-dark btn-lg btn-block" href="/adminregistration" >Admin Registration</a> */}
                      <div className="d-flex align-items-center mb-3 pb-1">
                        <i
                          className="fas fa-key fa-2x me-3"
                          style={{ color: " #000" }}
                        ></i>
                        <span className="h1 fw-bold mb-0">Tainer Register</span>
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">Username</label>
                        <input
                          type="text"
                          placeholder="enter your username"
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
                        <label className="form-label">Password</label>
                        <input
                          type="password"
                          placeholder="enter your password"
                          className="form-control form-control-lg"
                          required
                          minLength={8}
                          maxLength={16}
                          onBlur={(e) => {
                            setPassword(e.target.value);
                          }}
                        />
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">Full Name</label>
                        <input
                          type="text"
                          placeholder="enter your full name"
                          className="form-control form-control-lg"
                          required
                          minLength={1}
                          maxLength={16}
                          onBlur={(e) => {
                            setFullname(e.target.value);
                          }}
                        />
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">Speciality</label>
                        <input
                          type="text"
                          placeholder="enter your speciality"
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
                          className="form-control form-control-lg"
                          required
                          minLength={3}
                          maxLength={16}
                          onBlur={(e) => {
                            setContact(e.target.value);
                          }}
                        />
                      </div>
                      <div>
                        <label className="form-label">Status</label>
                        <select
                          className="form-select btn btn-dark btn-lg btn-block"
                          aria-label="Default select example"
                          onChange={(e) => {
                            setStatus(e.target.value);
                          }}
                        >
                          <option>Select</option>
                          <option value="active">Active</option>
                          <option value="inactive">InActive</option>
                        </select>
                      </div>
                      <b style={{ color: "red" }}>{messege}</b>
                      <div className="pt-1 mb-4">
                        <button
                          className="btn btn-dark btn-lg btn-block"
                          type="button"
                          onClick={addData}
                        >
                          Register
                        </button>
                      </div>
                      <div className="pt-1 mb-4">
                        <button
                          className="btn btn-dark btn-lg btn-block"
                          type="Reset"
                        >
                          Reset
                        </button>
                      </div>
                      <a style={{ color: "black" }} href="/forgetpassword">
                        Forgot password?
                      </a>
                      <p className="mb-5 pb-lg-2" style={{ color: " #fff" }}>
                        Already't have an account?{" "}
                        <a href="/login" style={{ color: " #000" }}>
                          Login here
                        </a>
                      </p>
                      <a href="/termsAndCondition" style={{ color: "black" }}>
                        Terms and Conditions.
                      </a>
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

export default TrainerRegister;
