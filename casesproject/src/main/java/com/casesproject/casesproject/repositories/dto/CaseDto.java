package com.casesproject.casesproject.repositories.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseDto {
	private String title;
	private String description;
	private Integer severity;
	private String status;
	private String userEmail;
	private String noteDetail;
}
