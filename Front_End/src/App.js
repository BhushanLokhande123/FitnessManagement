import React, { Component } from "react";
import {
  BrowserRouter as Router,
  Route,
  Redirect,
  Switch,
} from "react-router-dom";
import About from "./pages/About/About";
import Contact from "./pages/Contact/Contact";
import Home from "./pages/Home/Home";
import Services from "./pages/Service/Services";
import Navbar from "./Components/Navbar/Navbar";
import { ReactSession } from "react-client-session";
import Login from "./pages/Login/Login";
import "./App.css";
import ForgetPassword from "./pages/ForgetPassword/ForgetPassword";
import TermsAndCondition from "./pages/terms/TermsAndCondition";
import Footer from "./Components/Navbar/Footer";
import MemberRegistration from "./pages/Register/MemberRegister";
import TrainerRegistration from "./pages/Register/TrainerRegister";
import Admin from "./pages/Profile/Admin/Admin";
import Trainer from "./pages/Profile/Trainer/Trainer";
import Member from "./pages/Profile/Member/Member";
import UpdateAdmin from "./pages/Profile/Admin/UpdateAdmin";
import UpdateTrainer from "./pages/Profile/Trainer/UpdateTrainer";
import UpdateMember from "./pages/Profile/Member/UpdateMember";
import Payment from "./pages/Register/Payment";
import AdminRegister from "./pages/Register/AdminRegister";
import GetAllMemberbyid from "./pages/Profile/Trainer/GetAllMemberbyid";
import GetAllTrainer from "./pages/Profile/Admin/GetAllTrainer";
import GetAllMember from "./pages/Profile/Admin/GetAllMember";
import GetAllAdmin from "./pages/Profile/Admin/GetAllAdmin";
import GetPaymentDetail from "./pages/Profile/Admin/GetPaymentDetail";
import GetMemberTrainingPlan from "./pages/Profile/Member/GetMemberTrainingPlan";
import GetTrainerInfo from "./pages/Profile/Member/GetTrainerInfo";
import UpdateTrainingPlan from "./pages/Profile/Trainer/UpdateTrainingPlan";
import Page from "./pages/page";

ReactSession.setStoreType("localStorage");

class App extends Component {
  render() {
    return (
      <div>
        <div>
          <Router>
            <Navbar />
            <main className="container">
              <Switch>
                <Route path="/page" exact>
                  <Page />
                </Route>
                <Route path="/" exact>
                  <Home />
                </Route>
                <Route path="/home" exact>
                  <Home />
                </Route>
                <Route path="/about" exact>
                  <About />
                </Route>
                <Route path="/service" exact>
                  <Services />
                </Route>
                <Route path="/contact" exact>
                  <Contact />
                </Route>
                <Route path="/forgetpassword" exact>
                  <ForgetPassword />
                </Route>
                <Route path="/termsAndCondition" exact>
                  <TermsAndCondition />
                </Route>
                <Route path="/admin" exact>
                  <Admin />
                </Route>
                <Route path="/trainer" exact>
                  <Trainer />
                </Route>
                <Route path="/member" exact>
                  <Member />
                </Route>
                <Route path="/updateadmin" exact>
                  <UpdateAdmin />
                </Route>
                <Route path="/updatetrainer" exact>
                  <UpdateTrainer />
                </Route>
                <Route path="/updatemember" exact>
                  <UpdateMember />
                </Route>
                <Route path="/payment" exact>
                  <Payment />
                </Route>
                <Route path="/getalltrainer" exact>
                  <GetAllTrainer />
                </Route>
                <Route path="/getallmember" exact>
                  <GetAllMember />
                </Route>
                <Route path="/getalladmin" exact>
                  <GetAllAdmin />
                </Route>
                <Route path="/getallpaymentdetail" exact>
                  <GetPaymentDetail />
                </Route>
                <Route path="/getallmemberbyid" exact>
                  <GetAllMemberbyid />
                </Route>
                <Route path="/getmembertrainingplan" exact>
                  <GetMemberTrainingPlan />
                </Route>
                <Route path="/gettrainerinfo" exact>
                  <GetTrainerInfo />
                </Route>
                <Route path="/updatetrainingplan" exact>
                  <UpdateTrainingPlan />
                </Route>
                {ReactSession.get("userId") != null ? (
                  <>
                    <Redirect to="/home" />
                  </>
                ) : (
                  <>
                    <Route path="/login" exact>
                      <Login />
                    </Route>
                    <Route path="/memberregistration" exact>
                      <MemberRegistration />
                    </Route>
                    <Route path="/trainerregistration" exact>
                      <TrainerRegistration />
                    </Route>
                    <Route path="/adminregistration" exact>
                      <AdminRegister />
                    </Route>
                  </>
                )}
                <Redirect to="/home" />
                {ReactSession.get("user") != null ? (
                  <></>
                ) : (
                  <>
                    <Route path="/login" exact>
                      <Login />
                    </Route>
                  </>
                )}
              </Switch>
            </main>
          </Router>
        </div>
        <div className="footer">
          <Footer />
        </div>
      </div>
    );
  }
}

export default App;
