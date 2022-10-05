package com.fitness.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fitness.entities.FitnessBranch;
import com.fitness.entities.User;
import com.fitness.exceptions.ResourceNotFoundException;
import com.fitness.payloads.BranchPageResponse;
import com.fitness.payloads.FitnessBranchDto;
import com.fitness.payloads.UserPageResponse;
import com.fitness.payloads.UserDto;
import com.fitness.repository.FitnessBranchRepo;
import com.fitness.repository.UserRepo;

@Service
public class FitnessBranchServiceImpl implements IFitnessBranchService {

	@Autowired
	private FitnessBranchRepo fitnessBranchRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public FitnessBranchDto createBranch(FitnessBranchDto branchDto) {
		
		FitnessBranch branch = this.modelMapper.map(branchDto, FitnessBranch.class);
		
		FitnessBranch saveBranch = this.fitnessBranchRepo.save(branch);
		
		return this.modelMapper.map(saveBranch, FitnessBranchDto.class);
	}

	
	@Override
	public FitnessBranchDto updateBranch(FitnessBranchDto branchDto, Integer branchId) {
		
		FitnessBranch branch = this.fitnessBranchRepo.findById(branchId).orElseThrow(()->new 
				ResourceNotFoundException("FitnessBranch", "Branch id", branchId));
		
		branch.setName(branchDto.getName());
		branch.setInfo(branchDto.getInfo());
		branch.setContact(branchDto.getContact());
		branch.setAddress(branchDto.getAddress());
		
		FitnessBranch updatedBranch = this.fitnessBranchRepo.save(branch);
		
		return this.modelMapper.map(updatedBranch , FitnessBranchDto.class);
	}

	@Override
	public void deleteBranch(Integer branchId) {
		FitnessBranch branch = this.fitnessBranchRepo.findById(branchId).orElseThrow(()->new 
				ResourceNotFoundException("FitnessBranch", "Branch id", branchId));
		this.fitnessBranchRepo.delete(branch);
	}

	@Override
	public FitnessBranchDto getBranchById(Integer branchId) {
		
		FitnessBranch branch = this.fitnessBranchRepo.findById(branchId).orElseThrow(()->new 
				ResourceNotFoundException("FitnessBranch", "Branch id", branchId));
		
		return this.modelMapper.map(branch, FitnessBranchDto.class);
	}
	

	@Override
	public UserDto assignBranchToUser(Integer userId, Integer branchId) {
		System.out.println("In asign branch method");
		
		FitnessBranch fitnessBranch = this.fitnessBranchRepo.findById(branchId).orElseThrow(() -> new 
				ResourceNotFoundException("FitnessBranch", "Branch id", branchId));
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User id", userId));
		
		System.out.println(fitnessBranch);
		System.out.println(user);
		
		user.setFitnessBranch(fitnessBranch);
//		fitnessBranch.getUser().add(user);
		
		User user2 = this.userRepo.save(user);
		
		return this.modelMapper.map(user2, UserDto.class);
	}


	@Override
	public BranchPageResponse getAllBranch(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		
		org.springframework.data.domain.Sort sort = (sortDir.equalsIgnoreCase("asc"))
				? (org.springframework.data.domain.Sort.by(sortBy).ascending())
				: (org.springframework.data.domain.Sort.by(sortBy).descending());

		Pageable p = PageRequest.of(pageNumber, pageSize, sort);
		
		Page<FitnessBranch> branchPage = this.fitnessBranchRepo.findAll(p);
		
		List<FitnessBranch> allBranch = branchPage.getContent();
		
		List<FitnessBranchDto> branchDto = allBranch.stream().map((branch) -> this.modelMapper.
				map(branch, FitnessBranchDto.class)).collect(Collectors.toList());
		
		BranchPageResponse pageResponse  = new BranchPageResponse();
		pageResponse.setContent(branchDto);
		pageResponse.setPagenumber(branchPage.getNumber());
		pageResponse.setPageSize(branchPage.getSize());
		pageResponse.setTotalElements(branchPage.getTotalElements());
		pageResponse.setTotalPages(branchPage.getTotalPages());
		pageResponse.setLastPage(branchPage.isLast());
		
		return pageResponse;
	}



}
