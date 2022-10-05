import React from 'react'
import './Services.css'
import i1 from './exercise.png'
import i2 from './multiple-users-silhouette.png'
import i3 from './trainer.png'
import i4 from './herbs.png'
import i5 from './childcare.png'
import i6 from './buddhist-yoga-pose.png'
import i7 from './court.png'
import i8 from './swimmer.png'
import i9 from './24-hours.png'

const Services = () => {
  return (
    <div className="container">
    <section>
      <div className="row">
        <h1 className="section-heading">Our Services</h1>
      </div>
      <div className="row">
        <div className="column">
          <div className="card">
            <div className="icon-wrapper">
              <i ><img src={i1} width={50} height={50}/></i>
            </div>
            <h3>State-of-the-Art Equipment</h3>
            <p>
            Each Fitness-Hub facility offers high quality cardio & strength equipment.
            </p>
          </div>
        </div>
        <div className="column">
          <div className="card">
            <div className="icon-wrapper">
            <i ><img src={i2} width={50} height={50}/></i>                               
            </div>
            <h3> Group Classes</h3>
            <p>
            We offer classes for yoga, spin, Zumba, Circuit Training, MX4 and more.
            </p>
          </div>
        </div>
        <div className="column">
          <div className="card">
            <div className="icon-wrapper">
            <i ><img src={i3} width={50} height={50}/></i>
            </div>
            <h3>Personal Trainers</h3>
            <p>
            Maximize your workout with the help of our personal trainers.
            </p>
          </div>
        </div>
        <div className="column">
          <div className="card">
            <div className="icon-wrapper">
            <i ><img src={i4} width={50} height={50}/></i>
            </div>
             <h3>Spa Services</h3>
            <p>
            Relax after an intense workout with any one of our spa services.
            </p>
          </div>
        </div>
        <div className="column">
          <div className="card">
            <div className="icon-wrapper">
            <i ><img src={i5} width={50} height={50}/></i>
            </div>
            <h3>  Childcare</h3>
            <p>
            Enjoy your workout knowing your children are safe & nearby.
            </p>
          </div>
        </div>
        <div className="column">
          <div className="card">
            <div className="icon-wrapper">
            <i ><img src={i6} width={50} height={50}/></i>
            </div>
            <h3> Yoga Classes</h3>
            <p>
            We take pride in offering personal experinces with our yoga classes.To explore your inner self and receive personalized guidance from your instructor.            </p>
          </div>
        </div>
       
        <div className="column">
          <div className="card">
            <div className="icon-wrapper">
            <i ><img src={i7} width={50} height={50}/></i>
            </div>
            <h3> Courts</h3>
            <p>
            Workout with your friends by hitting the racquetball & basketball courts.
            </p>
          </div>
        </div>
        <div className="column">
          <div className="card">
            <div className="icon-wrapper">
            <i ><img src={i8} width={50} height={50}/></i>
            </div>
            <h3> Aquatic Pool</h3>
            <p>
            Get your cardio on in another way, by swimming laps in the pool.    
            </p>
          </div>
        </div>
        <div className="column">
          <div className="card">
            <div className="icon-wrapper">
            <i ><img src={i9} width={50} height={50}/></i>
            </div>
            <h3>24/7 Access</h3>
            <p>
            Workout when the time is right for you with 24/7 access.
            </p>
          </div>
        </div>
      </div>
    </section>
    </div>
  )
}
export default Services;