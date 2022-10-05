package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.DietPlan;
import com.example.demo.entities.Login;
import com.example.demo.entities.Member;
@Repository
public interface DietPlanRepository extends JpaRepository<Member, Integer> {

	@Query("select d from DietPlan d where d.category= :category")
	List<DietPlan> getByCategory(String category);

	//@Query("select m from Member m where m.loginid= :lObj")
	//Optional<Member> checkMember(Login lObj);

}
