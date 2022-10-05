package com.fitness.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PackagePageResponse {
	
	private List<MemberPackageDto> content;
	private int pagenumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastPage;

}
