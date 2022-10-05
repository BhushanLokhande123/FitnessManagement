import Card from "react-bootstrap/Card";
import CardGroup from "react-bootstrap/CardGroup";
import "./About.css";
import i1 from "./gym.png";
import i2 from "./coach.png";
import i3 from "./protein.png";
import i4 from "./user.png";

function About() {
  return (
    <div className="about">
      <h4 style={{ textAlign: "center" }}>
        <i className="fas fa-dumbbell"></i>
        What is GYM
      </h4>
      <br />
      <h3>
        A gym is a place with a number of equipments and machines used by the
        people to do exercises.
      </h3>

      <p>
        The Online Gym is suitable for anyone regardless of their goals and
        fitness level. We can help you to achieve your goal whether it’s weight
        loss, gaining strength or size, general fitness, sport specific
        programming or whether it’s a quick blast in the comfort of your home.
        Not only do you get a programme specific to your needs you also get
        educated on how to overcome barriers and how to improve your nutrition.
        It is our goal to help you to become a better version of yourself. Below
        is our commitment to you.
      </p>
      <br />
      <br />
      <CardGroup>
        <Card>
          <Card.Img variant="top" src={i1} />
          <Card.Body>
            <Card.Title>A GREAT GYM</Card.Title>
            <Card.Text>
              Fitness-Hub Gym is not for the faint of heart! It is for beasts
              and warriors who are willing to push themselves beyond the limit.
            </Card.Text>
          </Card.Body>
        </Card>
        &nbsp;
        <Card>
          <Card.Img variant="top" src={i2} />
          <Card.Body>
            <Card.Title>BEST INSTRUCTORS</Card.Title>
            <Card.Text>
              Our equipped personal trainers will instill three values in each
              member: Motivation, Perseverance, and Satisfaction.
            </Card.Text>
          </Card.Body>
        </Card>
        &nbsp;
        <Card>
          <Card.Img variant="top" src={i3} />
          <Card.Body>
            <Card.Title>BEST SPORT NUTRITION</Card.Title>
            <Card.Text>
              Because we don’t want your hard physical work to go in vain, we
              have -special Supplement, and a healthy Diet.
            </Card.Text>
          </Card.Body>
        </Card>
        &nbsp;
        <Card>
          <Card.Img variant="top" src={i4} />
          <Card.Body>
            <Card.Title>PERSONAL PROGRAM</Card.Title>
            <Card.Text>
              For your workout plan! Our professional trainers will help you set
              your athletic goals and then push you over the top.{" "}
            </Card.Text>
          </Card.Body>
        </Card>
      </CardGroup>

      <br />
      <br />
      <br />
      <br />
      <br />
      <br />

      <section>
        <div className="container">
          <section>
            <div className="row">
              <h1 className="section-heading">Our Packages</h1>
            </div>
            <br />
            <br />
            <br />
            <br />
            <div className="row">
              <div className="column">
                <div className="card">
                  <h3>DAILY PASS</h3>
                  <h3>
                    <b>150 RS.</b>
                  </h3>
                  <p>
                    <li>Gym Access</li>
                  </p>
                  <div>
                    <a class="btn btn-warning" href="/memberregistration">
                      join now
                    </a>
                  </div>
                </div>
              </div>

              <div className="column">
                <div className="card">
                  <h3>WEEKLY PASS</h3>
                  <h3>
                    <b>500 RS.</b>
                  </h3>
                  <p>
                    <li>Gym Access</li>
                  </p>
                  <div>
                    <a class="btn btn-warning" href="/memberregistration">
                      join now
                    </a>
                  </div>
                </div>
              </div>

              <div className="column">
                <div className="card">
                  <h3>1 MONTH</h3>
                  <h3>
                    <b>1500 RS.</b>
                  </h3>
                  <p>
                    <li>Gym and Fitness</li>
                    <li>Classic Classes</li>
                  </p>
                  <div>
                    <a class="btn btn-warning" href="/memberregistration">
                      join now
                    </a>
                  </div>
                </div>
              </div>

              <div className="column">
                <div className="card">
                  <h3>2 MONTH</h3>
                  <h3>
                    <b>2500 RS.</b>
                  </h3>
                  <p>
                    <li>Gym and Fitness</li>
                    <li>Classic Classes</li>
                  </p>
                  <div>
                    <a class="btn btn-warning" href="/memberregistration">
                      join now
                    </a>
                  </div>
                </div>
              </div>

              <div className="column">
                <div className="card">
                  <h3>3 MONTH</h3>
                  <h3>
                    <b>3500 RS.</b>
                  </h3>
                  <p>
                    <li>Gym and Fitness</li>
                    <li>Classic Classes</li>
                  </p>
                  <div>
                    <a class="btn btn-warning" href="/memberregistration">
                      join now
                    </a>
                  </div>
                </div>
              </div>

              <div className="column">
                <div className="card">
                  <h3>6 MONTH</h3>
                  <h3>
                    <b>5600 RS.</b>
                  </h3>
                  <p>
                    <li>Gym and Fitness</li>
                    <li>Classic Classes</li>
                  </p>
                  <div>
                    <a class="btn btn-warning" href="/memberregistration">
                      join now
                    </a>
                  </div>
                </div>
              </div>

              <div className="column">
                <div className="card">
                  <h3>1 YEAR</h3>
                  <h3>
                    <b>8000 RS.</b>
                  </h3>
                  <p>
                    <li>Gym and Fitness</li>
                    <li>Classic Classes</li>
                  </p>
                  <div>
                    <a class="btn btn-warning" href="/memberregistration">
                      join now
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>
      </section>
    </div>
  );
}

export default About;
