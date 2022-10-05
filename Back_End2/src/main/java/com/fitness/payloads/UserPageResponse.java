package com.fitness.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserPageResponse {
	
	private List<UserDto> content;
	private int pagenumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastPage;

}
