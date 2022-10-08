package com.fitness.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fitness.config.AppConstants;
import com.fitness.entities.FitnessBranch;
import com.fitness.entities.MembershipPackage;
import com.fitness.entities.Role;
import com.fitness.entities.User;
import com.fitness.exceptions.ResourceNotFoundException;
import com.fitness.payloads.MemberPackageDto;
import com.fitness.payloads.UserPageResponse;
import com.fitness.payloads.UserDto;
import com.fitness.repository.FitnessBranchRepo;
import com.fitness.repository.MembPackageRepo;
import com.fitness.repository.RoleRepo;
import com.fitness.repository.UserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private FitnessBranchRepo fitBranchRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MembPackageRepo membPackageRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User id : ", userId));

		user.setContactNo(userDto.getContactNo());
		user.setEmail(userDto.getEmail());
		user.setImage(userDto.getImage());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());

		User saveUser = this.userRepo.save(user);

		return this.modelMapper.map(saveUser, UserDto.class);

	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User id : ", userId));

		this.userRepo.delete(user);

	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User id : ", userId));

		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getUserByBranch(Integer branchId) {

		FitnessBranch fitBranch = this.fitBranchRepo.findById(branchId)
				.orElseThrow(() -> new ResourceNotFoundException("Fitness Branch", "Branch Id : ", branchId));
		List<User> listBranch = this.userRepo.findByFitnessBranch(fitBranch);

		List<UserDto> collect = listBranch.stream().map((list) -> this.modelMapper.map(list, UserDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public UserDto registerNewCustomer(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);

		// encoded password...
		user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));

		// roles ---> fetch user roles...rolerepository....

		Role role = this.roleRepo.findById(AppConstants.ROLE_CUSTOMER).get();

		user.getRoles().add(role);

		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);
	}

	@Override
	public UserDto createManagerUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);

		user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));

		Role role = this.roleRepo.findById(AppConstants.ROLE_MANAGER).get();

		user.getRoles().add(role);

		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);
	}

	@Override
	public UserDto createAdminUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);

		user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));

		Role role = this.roleRepo.findById(AppConstants.ROLE_ADMIN).get();

		user.getRoles().add(role);

		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);
	}

	
	//pagination...
	
	@Override
	public UserPageResponse getAllUser(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

		org.springframework.data.domain.Sort sort = (sortDir.equalsIgnoreCase("asc"))
				? (org.springframework.data.domain.Sort.by(sortBy).ascending())
				: (org.springframework.data.domain.Sort.by(sortBy).descending());

		Pageable p = PageRequest.of(pageNumber, pageSize, sort);

		Page<User> pageUser = this.userRepo.findAll(p);

		List<User> allUser = pageUser.getContent();

		List<UserDto> userDtos = allUser.stream().map((user) -> this.modelMapper.map(user, UserDto.class))
		.collect(Collectors.toList());
		
		UserPageResponse postResponse  = new UserPageResponse();
		postResponse.setContent(userDtos);
		postResponse.setPagenumber(pageUser.getNumber());
		postResponse.setPageSize(pageUser.getSize());
		postResponse.setTotalElements(pageUser.getTotalElements());
		postResponse.setTotalPages(pageUser.getTotalPages());
		postResponse.setLastPage(pageUser.isLast());

		return postResponse;
	}

}
