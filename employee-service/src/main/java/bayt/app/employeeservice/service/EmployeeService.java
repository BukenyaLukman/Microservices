package bayt.app.employeeservice.service;

import bayt.app.employeeservice.dto.APIResponseDTO;
import bayt.app.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDTO getEmployeeById(Long employeeId);
}
