import { useEffect, useState } from "react";
import axios from "axios";
import { ReactSession } from "react-client-session";

function UpdateAdmin() {
  const user = ReactSession.get("user");
  const [username, setUsername] = useState(user.username);
  const [fullname, setFullname] = useState(user.fullname);
  const [email, setEmail] = useState(user.email);
  const [contact, setContact] = useState(user.contactno);
  const [messege, setMessege] = useState();

  function updateData() {
    const updatedUser = {};
    updatedUser.username = username;
    // updatedUser.password = password;
    updatedUser.fullname = fullname;
    updatedUser.aid = user.aid;
    updatedUser.email = email;
    updatedUser.contactno = contact;
    //  updatedUser.status = status
    console.log(updatedUser);
    axios
      .post("http://localhost:8080/updateadmin", updatedUser)
      .then((response) => {
        console.log(response);
        setMessege(response.data);
        alert(" admin details updated successfully");
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
                        <label className="form-label">UserName</label>
                        <input
                          type="text"
                          placeholder="enter your username"
                          readOnly
                          className="form-control form-control-lg"
                          defaultValue={user.username}
                          required
                          minLength={1}
                          maxLength={16}
                          onBlur={(e) => {
                            setUsername(e.target.value);
                          }}
                        />
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">Full Name</label>
                        <input
                          type="text"
                          placeholder="enter your fullname"
                          readOnly
                          className="form-control form-control-lg"
                          defaultValue={user.fullname}
                          required
                          onBlur={(e) => {
                            setFullname(e.target.value);
                          }}
                        />
                      </div>
                      <div className="form-outline mb-4">
                        <label className="form-label">E-mail</label>
                        <input
                          type="mail"
                          placeholder="enter your email"
                          className="form-control form-control-lg"
                          defaultValue={user.email}
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
                          defaultValue={user.contactno}
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

export default UpdateAdmin;
