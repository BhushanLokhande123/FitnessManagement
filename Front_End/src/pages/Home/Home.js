import React, { useEffect, useState } from 'react'
import Carousel from 'react-bootstrap/Carousel';
import FirstSlide from './biceps.webp';
import SecondSlide from './dumble.jpg';
import ThirdSlide from './bar.webp';
import fourthslide from './banner.webp';
import './Home.css'




import Logo from './2.jpg'
import axios from 'axios';
import { Table } from 'react-bootstrap';



const Home = () => {
  const [users, setUsers] = useState([]);
  const [check, setCheck] = useState(false);
  useEffect(() => {
    axios.get("http://localhost:8080/getallactivetrainer")
      .then((response) => {
        setUsers(response.data);
        setCheck(true);
      })
      .catch((error) => {
        console.log(error);
      })
  }, [])


  return (
    <div className="container">
      <Carousel>
        <Carousel.Item>
          <img
            className="d-block w-100 h-25"
            src={FirstSlide}
            alt="First slide"
          />
          <Carousel.Caption>
            <h2>Once You Learn To Quit</h2>
            <b>It Becames A Habit</b>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100 h-25"
            src={fourthslide}
            alt="First slide"
          />
          <Carousel.Caption>
            <h2>You Are Much Stronger</h2>
            <b>Than You Think</b>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100 h-25"
            src={SecondSlide}
            alt="Second slide"
          />

          <Carousel.Caption>
            <h2>Look In The Mirror</h2>
            <b>That's Your Competition</b>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100 h-25"
            src={ThirdSlide}
            alt="Third slide"
          />

          <Carousel.Caption>
            <h2>Starve Your Distraction</h2>
            <b>Feed Your Focus</b>
          </Carousel.Caption>
        </Carousel.Item>

        <Carousel.Item>
          <img
            className="d-block w-100 h-25"
            src={Logo}
            alt="First slide"
          />
          <Carousel.Caption>
            <h2>Replace "I CAN'T"</h2>
            <b>With "I WILL"</b>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>

    
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <center>
     <h2><b>OUR PROFESSIONAL TRAINERS</b></h2>
     <br/>
     <br/>
     <br/>
      <Table striped bordered hover variant="dark" style={{ 'textAlign': 'center'}}>    
        <thead>
          <tr>
            <th>Trainer Id</th>
            <th>Full Name</th>
            <th>Speciality</th>
            <th>Email</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {check && users.map((user, index) => (
            <tr key={index}>
              <td>{user.tid}</td>
              <td>{user.fullname}</td>
              <td>{user.speciality}</td>
              <td>{user.email}</td>
              <td>{user.status}</td>
            </tr>
          ))}
        </tbody>
      </Table>

      </center>

      
      <div>
      </div>
    </div>
  )
}
export default Home;