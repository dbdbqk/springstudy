package com.gdu.staff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.service.StaffService;

@Controller
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/list.json") // responseEntity는 produces도 포함 할 수 있으며 포함 안하면 responsEntity를 만들때 만들어ㅑ함
	public ResponseEntity<List<StaffDTO>> list2(){
		return staffService.getStaffList2();
	}

	@PostMapping(value="/add.do", produces="text/plain; charset=UTF-8")
	public ResponseEntity<String> add2(StaffDTO staffDTO){
		return  staffService.addStaff2(staffDTO);
	}	
	@GetMapping("/query.json")
	public ResponseEntity<List<StaffDTO>> search(HttpServletRequest request){
		return staffService.searchStaff(request);
			
	}
	
}
