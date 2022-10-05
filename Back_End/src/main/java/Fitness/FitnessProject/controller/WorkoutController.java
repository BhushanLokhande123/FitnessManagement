package Fitness.FitnessProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Fitness.FitnessProject.models.Workout;

@RestController
@CrossOrigin
public class WorkoutController {
	@Autowired
	JdbcTemplate temp;

	@GetMapping("/getWorkoutplan/{id}")
	public Workout getWorkouts(@PathVariable int id) {
		Workout workout = new Workout();
		workout = temp.queryForObject("select * from Workout_plan where id = " + id, (rs, rowmap) -> {
			return new Workout(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getString(7), rs.getString(8));
		});
		return workout;
	}

	@PostMapping("/updateworkoutplan")
	public String UpdateWorkouts(@RequestBody Workout w) {
		String message = "";
		try {
			if (w == null) {
				message = "please enter values";
			} else {
				temp.update("update workout_plan set sunday='" + w.getSun() + "',monday='" + w.getMon() + "',tuesday='"
						+ w.getTue() + "',wednesday='" + w.getWed() + "',thursday='" + w.getThu() + "',friday='"
						+ w.getFri() + "',saturday='" + w.getSat() + "' where id = " + w.getId());
				message = "update workout_plan successfully";
			}

		} catch (Exception e) {
			message = " workout query fail";

		}
		return message;

	}
}
