import React from "react";
import Card from "react-bootstrap/Card";
import CardGroup from "react-bootstrap/CardGroup";
import emergency from "./emergency.webp";
import security from "./security.webp";
import support from "./support.webp";
const Contact = () => {
  const submitData = () => {
    alert("thanks for your generous response");
  };
  return (
    <div className="container">
      <h1 className="h1-responsive font-weight-bold text-center my-4">
        <i className="far fa-address-card"></i>
        Contact Us
      </h1>

      <div className="about">
        <CardGroup>
          <Card>
            <Card.Img variant="top" src={support} />
            <Card.Body>
              <Card.Title>Customer Support</Card.Title>
              <Card.Text>
                At Help Scout, we define modern customer support as the act of
                providing timely, empathetic help that keeps customers' needs at
                the forefront of every interaction.
              </Card.Text>
            </Card.Body>
          </Card>
          &nbsp;
          <Card>
            <Card.Img variant="top" src={security} />
            <Card.Body>
              <Card.Title>Customer Queries</Card.Title>
              <Card.Text>
                Solve customer queries via web, email, phone, SMS, and social
                media all in one place.Assist customers with online mode by
                using better intel and less manual work.
              </Card.Text>
            </Card.Body>
          </Card>
          &nbsp;
          <Card>
            <Card.Img variant="top" src={emergency} />
            <Card.Body>
              <Card.Title>We'd love to hear from you!</Card.Title>
              <Card.Text>
                Our goal is to encourage everyone to live an active and healthy
                lifestyle. Studies show having healthy employees improves
                productivity and radically reduces healthcare costs.{" "}
              </Card.Text>
            </Card.Body>
          </Card>
        </CardGroup>
      </div>
      <hr />
      <br />
      <br />
      <section className="mb-4">
        <h2 style={{ textAlign: "center" }}>Your Response Always Welcome</h2>
        <fieldset>
          <p className="text-center w-responsive mx-auto mb-5">
            If you're looking to join a supportive,welcoming gym community, with
            people of all fitness levels who want to see you succeed,you've come
            to the right place.
          </p>
          <div className="row">
            <div className="col-md-9 mb-md-0 mb-5">
              <form
                id="contact-form"
                name="contact-form"
                action="mail.js"
                method="POST"
              >
                <div className="row">
                  <div className="col-md-6">
                    <div className="md-form mb-0">
                      <input type="text" id="name" className="form-control" />
                      <label>Your name</label>
                    </div>
                  </div>

                  <div className="col-md-6">
                    <div className="md-form mb-0">
                      <input type="text" id="email" className="form-control" />
                      <label>Your email</label>
                    </div>
                  </div>
                </div>

                <div className="row">
                  <div className="col-md-12">
                    <div className="md-form mb-0">
                      <input
                        type="text"
                        id="subject"
                        name="subject"
                        className="form-control"
                      />
                      <label>Subject</label>
                    </div>
                  </div>
                </div>

                <div className="row">
                  <div className="col-md-12">
                    <div className="md-form">
                      <textarea
                        type="text"
                        id="message"
                        name="message"
                        rows="2"
                        className="form-control md-textarea"
                      ></textarea>
                      <label>Your message</label>
                    </div>
                  </div>
                </div>
              </form>

              <div className="text-center text-md-left">
                <a className="btn btn-primary" onClick={submitData}>
                  Send
                </a>
              </div>
            </div>

            <div className="col-md-3 text-center">
              <ul className="list-unstyled mb-0">
                <li>
                  <i className="fas fa-map-marker-alt fa-2x"></i>
                  <a href="https://www.bing.com/maps?&ty=17&q=golds%20map%20pune&segment=Local&mb=18.471479~73.833153~18.448286~73.887924&ppois=18.448286056518555_73.8331527709961_Gold%27s%20Gym_YN4070x8888385757665067915~18.471479415893555_73.88792419433594_Gold%27s%20Gym_YN4070x655428440777246995~&usebfpr=true&v=2&sV=1&FORM=SNAPST">
                    <p>Golds-gym Pvt Ltd Pune</p>
                  </a>
                </li>

                <li>
                  <i className="fas fa-phone mt-4 fa-2x"></i>
                  <p>+91 8446550870</p>
                </li>

                <li>
                  <i className="fas fa-envelope mt-4 fa-2x"></i>
                  <p>support-pune-helpline.com</p>
                </li>
              </ul>
            </div>
          </div>
        </fieldset>
      </section>
    </div>
  );
};
export default Contact;
