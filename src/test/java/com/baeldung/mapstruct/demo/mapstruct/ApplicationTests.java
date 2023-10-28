package com.baeldung.mapstruct.demo.mapstruct;

import com.mapstruct.api.dto.DivisionDTO;
import com.mapstruct.api.dto.EmployeeDTO;
import com.mapstruct.api.mapper.EmployeeMapper;
import com.mapstruct.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor
class ApplicationTests {
	private final EmployeeMapper mapper;
	private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
	@Test
	void contextLoads() {
	}

	@Test
	public void givenEmpStartDtMappingToEmpDTO_whenMaps_thenCorrect() throws ParseException {
		Employee entity = new Employee();
		entity.setStartDt(new Date());
		EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);

		assertEquals(format.parse(dto.getEmployeeStartDt()).toString(),
				entity.getStartDt().toString());
	}

	@Test
	public void givenEmpDTONestedMappingToEmp_whenMaps_thenCorrect() {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setDivision(new DivisionDTO(1, "Division1"));

		Employee entity = mapper.employeeDTOtoEmployee(dto);
		assertEquals(dto.getDivision().getId(),
				entity.getDivision().getId());
		assertEquals(dto.getDivision().getName(),
				entity.getDivision().getName());
	}
}
