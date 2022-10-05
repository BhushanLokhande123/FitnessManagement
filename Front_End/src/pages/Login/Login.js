import { useEffect, useState } from "react";
import i1 from "./21.jpg";
import i2 from "./22.jpg";
import axios from "axios";

import { ReactSession } from "react-client-session";
import { useHistory } from "react-router-dom";

function Login() {
  const [username, setusername] = useState("");
  const [password, setPassword] = useState("");
  const [messege, setMesssge] = useState("");
  const [role, SetRole] = useState();
  const [userId, setUserId] = useState();

  const Verify = () => {
    const login = {};
    login.username = username;
    login.password = password;

    axios
      .post("http://localhost:8080/login", login)
      .then((response) => {
        if (response.data == 0) {
          setMesssge("Invalid Username Or Password");
        } else {
          setUserId(response.data);
          axios
            .get("http://localhost:8080/getrole/" + response.data)
            .then((response) => {
              SetRole(response.data);
              alert(" logged in as a " + response.data);
            })
            .catch((error) => {
              console.log(error);
            });
        }
      })
      .catch((error) => {
        console.log(error);
      });
    // refresh();
  };

  const refresh = () => {
    window.location.reload(false);
  };
  const history = useHistory();
  useEffect(() => {
    if (role == "admin") {
      ReactSession.set("userId", userId);
      history.push("/admin");
    }
    if (role == "member") {
      ReactSession.set("userId", userId);
      history.push("/member");
    }
    if (role == "trainer") {
      ReactSession.set("userId", userId);
      history.push("/trainer");
    }
  });

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
                </div>
                <div className="col-md-6 col-lg-7 d-flex align-items-center">
                  <div
                    className="card-body p-4 p-lg-5 text-black"
                    style={{ backgroundColor: "rgb(5, 101, 134)" }}
                  >
                    <form>
                      <div className="d-flex align-items-center mb-3 pb-1">
                        <i className="fas fa-lock fa-2x me-3"></i>
                        <span className="h1 fw-bold mb-0">LOGIN</span>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="text"
                          id="form2Example17"
                          className="form-control form-control-lg"
                          onBlur={(e) => {
                            setusername(e.target.value);
                          }}
                        />
                        <label className="form-label">Username</label>
                      </div>

                      <div className="form-outline mb-4">
                        <input
                          type="password"
                          id="form2Example27"
                          className="form-control form-control-lg"
                          onBlur={(e) => {
                            setPassword(e.target.value);
                          }}
                        />
                        <label className="form-label">Password</label>
                      </div>

                      <div className="pt-1 mb-4">
                        <b>{messege}</b>
                        <button
                          className="btn btn-dark btn-lg btn-block"
                          type="button"
                          onClick={Verify}
                        >
                          Login
                        </button>
                      </div>
                      <a href="/forgetpassword" style={{ color: "black" }}>
                        Forgot password?
                      </a>
                      <p className="mb-5 pb-lg-2" style={{ color: " #fff" }}>
                        Don't have an account?{" "}
                        <a
                          href="/memberregistration"
                          style={{ color: " #000" }}
                        >
                          Register here
                        </a>
                      </p>
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

export default Login;
