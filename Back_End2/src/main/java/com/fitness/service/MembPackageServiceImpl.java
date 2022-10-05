package com.fitness.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fitness.entities.MembershipPackage;
import com.fitness.entities.User;
import com.fitness.exceptions.ResourceNotFoundException;
import com.fitness.payloads.MemberPackageDto;
import com.fitness.payloads.PackagePageResponse;
import com.fitness.payloads.UserDto;
import com.fitness.repository.MembPackageRepo;
import com.fitness.repository.UserRepo;

@Service
public class MembPackageServiceImpl implements IMembPackageService {

	@Autowired
	private MembPackageRepo membPackageRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public MemberPackageDto createPackage(MemberPackageDto membPackageDto) {
		MembershipPackage MembershipPackage = this.modelMapper.map(membPackageDto, MembershipPackage.class);
		MembershipPackage savePackage = this.membPackageRepo.save(MembershipPackage);
		return this.modelMapper.map(savePackage, MemberPackageDto.class);
	}

	@Override
	public MemberPackageDto updatePackage(MemberPackageDto membPackageDto, Integer packageId) {
		MembershipPackage MemPackage = this.membPackageRepo.findById(packageId).
		orElseThrow(()-> new ResourceNotFoundException("MembershipPackage", "Package Id", packageId));
		
		MemPackage.setName(membPackageDto.getName());
		MemPackage.setDuration(membPackageDto.getDuration());
		MemPackage.setAmount(membPackageDto.getAmount());
		MemPackage.setDescription(membPackageDto.getDescription());
		
		MembershipPackage save = this.membPackageRepo.save(MemPackage);
		
		
		return this.modelMapper.map(save, MemberPackageDto.class);
	}

	@Override
	public void deletePackage(Integer packageId) {
		MembershipPackage MemPackage = this.membPackageRepo.findById(packageId).
				orElseThrow(()-> new ResourceNotFoundException("MembershipPackage", "Package Id", packageId));
		this.membPackageRepo.delete(MemPackage);
		
	}

	@Override
	public MemberPackageDto getPackageById(Integer packageId) {
		MembershipPackage MemPackage = this.membPackageRepo.findById(packageId).
				orElseThrow(()-> new ResourceNotFoundException("MembershipPackage", "Package Id", packageId));
		
		return this.modelMapper.map(MemPackage, MemberPackageDto.class);
	}

	@Override
	public UserDto assignPackageToUser(Integer userId, Integer packageId) {
		
		MembershipPackage MemPackage = this.membPackageRepo.findById(packageId).
				orElseThrow(()-> new ResourceNotFoundException("MembershipPackage", "Package Id", packageId));
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new 
				ResourceNotFoundException("User", "User Id", userId));
		
		user.setMemberPackage(MemPackage);
		
		User user2 = userRepo.save(user);
		
		return this.modelMapper.map(user2, UserDto.class);
	}

	@Override
	public PackagePageResponse getAllPackage(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		
		org.springframework.data.domain.Sort sort = (sortDir.equalsIgnoreCase("asc"))
				? (org.springframework.data.domain.Sort.by(sortBy).ascending())
				: (org.springframework.data.domain.Sort.by(sortBy).descending());

		Pageable p = PageRequest.of(pageNumber, pageSize, sort);
		
		Page<MembershipPackage> pkg = this.membPackageRepo.findAll(p);
		
		List<MembershipPackage> content = pkg.getContent();
		
		List<MemberPackageDto> packgeDto = content.stream().map((list) -> this.modelMapper
				.map(list, MemberPackageDto.class)).collect(Collectors.toList());
		
		PackagePageResponse packageResponse = new PackagePageResponse();
		packageResponse.setContent(packgeDto);
		packageResponse.setPagenumber(pkg.getNumber());
		packageResponse.setPageSize(pkg.getSize());
		packageResponse.setTotalElements(pkg.getTotalElements());
		packageResponse.setTotalPages(pkg.getTotalPages());
		packageResponse.setLastPage(pkg.isLast());
		
		return packageResponse;
	}

}
