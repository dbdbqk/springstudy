package com.gdu.staff.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StaffDTO {

	private String sno;
	private String name;
	private String dept;
	private int salary;
	
}
