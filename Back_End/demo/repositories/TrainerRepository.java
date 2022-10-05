package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Login;
import com.example.demo.entities.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

	@Query("select t from Trainer t where t.loginid= :lObj")
	Optional<Trainer> checkTrainer(Login lObj);

	@Query("select t from Trainer t where t.speciality= :category")
	List<Trainer> getTrainerDetail(String category);

}
