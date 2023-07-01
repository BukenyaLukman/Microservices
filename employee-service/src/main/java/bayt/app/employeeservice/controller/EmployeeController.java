package bayt.app.employeeservice.controller;


import bayt.app.employeeservice.dto.APIResponseDTO;
import bayt.app.employeeservice.dto.EmployeeDto;
import bayt.app.employeeservice.entity.Employee;
import bayt.app.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    // Build save employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employee) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    // Build get employee by id rest api
    @GetMapping("{employee-id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable("employee-id") Long employeeId) {
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
