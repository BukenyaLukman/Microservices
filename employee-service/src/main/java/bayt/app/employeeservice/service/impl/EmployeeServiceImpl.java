
package bayt.app.employeeservice.service.impl;

import bayt.app.employeeservice.dto.APIResponseDTO;
import bayt.app.employeeservice.dto.DepartmentDto;
import bayt.app.employeeservice.dto.EmployeeDto;
import bayt.app.employeeservice.entity.Employee;
import bayt.app.employeeservice.repository.EmployeeRepository;
import bayt.app.employeeservice.service.APIClient;
import bayt.app.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
    //private WebClient  webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );http://127.0.0.1:8080/api/departments/MK221
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> response = restTemplate.getForEntity("http://127.0.0.1:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = response.getBody();

//        DepartmentDto departmentDto =  webClient.get()
//                .uri("http://127.0.0.1:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();


        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());



        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployee(employeeDto);
        apiResponseDTO.setDepartment(departmentDto);


        return apiResponseDTO;
    }
}
