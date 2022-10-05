package Fitness.FitnessProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Fitness.FitnessProject.models.Diet;

@RestController
@CrossOrigin
public class DietController {
	@Autowired
	JdbcTemplate temp;

    @GetMapping("/getdietplan/{id}")
    public Diet getDiets(@PathVariable int id)
    {
        Diet diet=new Diet();
        diet =  temp.queryForObject("select * from diet_plan where id = "+id,(rs,rowmap)->{return new Diet(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));});
        return diet;
    }


    @PostMapping("/updatedietplan")
    public String UpdateWorkouts(@RequestBody Diet d )
    {
       String message="";
       try {
        temp.update("update diet_plan set sunday='"+d.getSun()+"',monday='"+d.getMon()+"',tuesday='"+d.getTue()+"',wednesday='"+d.getWed()+"',thursday='"+d.getThu()+"',friday='"+d.getFri()+"',saturday='"+d.getSat()+"' where id = "+d.getId());
        message="update diet_plan successfully";
       } catch (Exception e) {
        message="query fail";

       }
      return message;
      
    }
}
