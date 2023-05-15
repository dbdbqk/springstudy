package com.gdu.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

// JUnit4
@RunWith(SpringJUnit4ClassRunner.class)


@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})



@FixMethodOrder(MethodSorters.NAME_ASCENDING)  // 메소드명의 알파벳순으로 테스트를 수행한다.
public class StaffUnitTest {

	
	@Autowired
	private StaffMapper staffMapper;
	
	

	private static final Logger LOGGER = LoggerFactory.getLogger(StaffUnitTest.class);
	
	
	// 테스트 메소드
	@Test
	public void 사원삽입테스트() {
		StaffDTO staff = new StaffDTO("99999", "김기획", "기획부", 5000);
		assertEquals(1, staffMapper.addStaff(staff));
	}
	
	@Test
	public void 사원조회테스트() {
		String staffSno = "11111";  
		List<StaffDTO> staff = staffMapper.searchStaff(staffSno);
		LOGGER.info(staff.toString());
		assertNotNull(staff);  
	}

	
}